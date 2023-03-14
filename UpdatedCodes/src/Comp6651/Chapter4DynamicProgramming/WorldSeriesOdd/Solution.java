package Comp6651.Chapter4DynamicProgramming.WorldSeriesOdd;

public class Solution {
    public static void main(String[] args) {
        int i = 2;
        int j = 2;
        int n = 2;
        System.out.println(calculate(i,j,n));
    }

    public static double calculate(int I, int J, int n) {
        double[][] p = new double[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == n) {
                    p[i][j] = 1;
                }
                if (j == n) {
                    p[i][j] = 0;
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                p[i][j] = 0.5 * (p[i+1][j] + p[i][j+1]);
            }
        }

        return p[I][J];
    }

    public static double calculateProbability(int I, int J, int n) {
        // initialize computational array
        double[][] p = new double[n+1][n+1];

        // base cases
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 && j > 0) {
                    p[i][j] = 1;
                } else if (i > 0 && j == 0) {
                    p[i][j] = 0;
                }
            }
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                    p[i][j] = 0.5 * p[i-1][j] + 0.5 * p[i][j-1];
            }
        }

        return p[n-I][J];
    }
}
