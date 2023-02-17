package Comp6651.Chapter4DynamicProgramming.editdistance;

public class Solution {
    public static void main(String[] args) {
        String A = "sunday";
        String B = "saturday";
        System.out.println(editDistance(A, B));
    }

    public static int editDistance(String A, String B) {
        int n1 = A.length();
        int n2 = B.length();
        if (A.equals(B)) return 0;
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        int[][] dp = new int[n1+1][n2+1];
        // base case
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    var editDelete = 1 + dp[i-1][j];
                    var editInsert = 1 + dp[i][j-1];
                    var editReplace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(editReplace, Math.min(editDelete, editInsert));
                }
            }
        }
        return dp[n1][n2];
    }
}
