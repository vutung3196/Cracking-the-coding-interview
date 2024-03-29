package Chapter4DynamicProgramming.SubsetSum;

public class Solution {
    public static void main(String[] args) {
        var input = new int[] {3, 34, 4, 12, 5, 2};
        var T = 38;
        System.out.println(subsetSumTV2(input, T));
    }

    public static boolean subSetSumsT(int[] A, int T) {
        boolean[][] dp = new boolean[A.length+1][T+1];
        // base case
        dp[A.length][0] = true;
        // down from A.length - 1 to dp[0] and increase to t
        for (int i = A.length - 1; i >= 0; i--) {
            dp[i][0] = true;
            for (int t = 1; t < A[i] - 1; t++) {
                if (t <= T) {
                    dp[i][t] = dp[i+1][t];
                }
            }
            for (int t = A[i]; t <= T; t++) {
                dp[i][t] = dp[i + 1][t] || dp[i + 1][t - A[i]];
            }
        }

        return dp[0][T];
    }

    public static boolean subsetSumTV2(int[] X, int T) {
        boolean[][] ss = new boolean[X.length+1][T+1];
        ss[X.length][0] = true;
        for (int i = X.length - 1; i >= 0; i--) {
            ss[i][0] = true;
            for (int t = 1; t <= X[i] - 1; t++) {
                if (t < T) {
                    ss[i][t] = ss[i+1][t];
                }
            }
            for (int t = X[i]; t <= T; t++) {
                ss[i][t] = ss[i + 1][t] || ss[i + 1][t - X[i]];
            }
        }

        // output
        return ss[0][T];
    }
}
