package Comp6651.Chapter4DynamicProgramming.MatrixMultiplication;

public class Solution {
    public static void main(String[] args) {

    }

    public static int solve(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                D[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = D[i][k] + D[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (q < D[i][j]) {
                        D[i][j] = q;
                    }
                }
            }
        }
        return D[0][n - 1];
    }
}
