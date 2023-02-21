package Comp6651.Chapter4DynamicProgramming.NeatlyPrinting;

public class Solution {
    public static void main(String[] args) {

    }

    private static class Cost {
        int referenceTable;
        int cost;
    }

    public static int solve(int[] words, int lineLength) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + words[i - 1];
        }
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                D[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int length = prefixSum[j + 1] - prefixSum[i];
                if (length <= lineLength) {
                    D[i][j] = (int) Math.pow(lineLength - length, 3);
                }
            }
        }
        int[] C = new int[n];
        int[] R = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            C[i] = D[i][n - 1];
            R[i] = n;
            for (int j = n - 1; j > i; j--) {
                if (D[i][j - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                if (C[i] > C[j] + D[i][j - 1]) {
                    C[i] = C[j] + D[i][j - 1];
                    R[i] = j;
                }
            }
        }
        return C[0];
    }

    public static Cost[] printNeatly(int M, int n, String[] words) {
        // compute a table of c values from left to right, since each value
        // depends only on earlier values
        int[][] extras = new int[n][n];
        // cost of including a line containing words i through j in the sum
        // we want to minimize
        // costOfLine[i][j]: cost of including a line
        // containing words i through j in the sum we want to minimize
        int[][] costOfLine = new int[n][n];
        Cost[] costs = new Cost[n+1];
        int[] c = new int[n+1];
        int[] p = new int[n+1];
        // Compute the extras[i,j] for 1 <= i <= j <= n
        for (int i = 0; i < n; i++) {
            extras[i][i] = M - words[i].length();
            for (int j = i + 1; j < n; j++) {
                extras[i][j] = extras[i][j-1] - words[j].length() - 1;
            }
        }

        // calculate the lc[i,j] for 1 <= i <= j <= n
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (extras[i][j] < 0) {
                    costOfLine[i][j] = Integer.MAX_VALUE;
                } else if (j == n-1 && extras[i][j] >= 0) {
                    costOfLine[i][j] = 0;
                } else {
                    costOfLine[i][j] = (extras[i][j]*extras[i][j]);
                }
            }
        }
        c[0] = 0;
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (c[i-1] + costOfLine[i][j] < c[j]) {
                    c[j] = c[i-1] + costOfLine[i][j];
                    p[j] = i;
                    costs[j].cost = c[j];
                    costs[j].referenceTable = p[j];
                }
            }
        }
        return costs;
    }


}
