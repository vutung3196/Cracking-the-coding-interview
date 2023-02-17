package Comp6651.Chapter4DynamicProgramming.LongestCommonSubsequence;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solve("counter", "counteract"));
    }

    public static int solve(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] D = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            D[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            D[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    D[i][j] = Math.max(D[i][j], 1 + D[i-1][j-1]);
                }
            }
        }

        return D[m][n];
    }
}
