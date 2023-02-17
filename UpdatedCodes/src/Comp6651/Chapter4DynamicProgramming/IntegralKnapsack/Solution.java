package Comp6651.Chapter4DynamicProgramming.IntegralKnapsack;

public class Solution {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(solve(wt, val, W, n));
    }

    public static int solve(int[] weights, int[] values, int W, int n) {
        int K[][] = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else {
                    K[i][w] = K[i-1][w];
                    if (weights[i-1] <= w) {
                        K[i][w] = Math.max(K[i-1][w], K[i-1][w-weights[i]]
                                + values[i]);
                    } else {
                        K[i][w] = K[i-1][w];
                    }
                }
            }
        }
        return K[n][W];
    }
}
