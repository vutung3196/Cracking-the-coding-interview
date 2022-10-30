package dynamicprogramming.climbingstairs;

import java.util.HashMap;

public class Solution {
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

    }

    // Bottom up
    // O(n) time and space complexity
    private static int minCostClimbingStairs(int[] cost) {
        // minimumCost[i]: represents the minimum cost of reaching the ith step
        int[] minimumCost = new int[cost.length + 1];
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoStep = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoStep);
        }

        return minimumCost[minimumCost.length - 1];
    }

    // Top down solution
    // O(n) time and space complexity
    private static int minimumCost(int i, int[] cost) {
        if (i == 0 || i == 1) return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }

    // Bottom up O(1) time complexity
    private static int minCostClimbingStairsWithoutUsingArray(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }
        return downOne;
    }
}
