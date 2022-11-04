package dynamicprogramming.diceroll;

public class Solution {
    /**
     * We have n dice, each having k faces with a number from 1 to k.
     * We need to find the number of ways to roll these nnn dice such that the sum of numbers on them is equal to target.
     * @param args
     */
    public static void main(String[] args) {

    }

    final int MOD = 1000000007;

    /**
     * Brute-force solution
     * O(n*k*target): time complexity
     * @param n
     * @param k
     * @param target
     * @return
     */
    public int numRollsToTarget(int n, int k, int target) {
        // memorization
        Integer[][] memo = new Integer[n + 1][target + 1];
        return waysToTarget(memo, 0, n, 0, target, k);
    }

    private int waysToTarget(Integer[][] memo, int diceIndex, int n, int currSum, int target, int k) {
        // all the n dice are traversed, the sum must be equal to target for valid combination
        if (diceIndex == n) {
            return currSum == target ? 1 : 0;
        }

        // we have already calculated the answer so no need to go into recursion
        if (memo[diceIndex][currSum] != null) {
            return memo[diceIndex][currSum];
        }

        int ways = 0;
        for (int i = 1; i <= Math.min(k, target - currSum); i++) {
            ways = (ways + waysToTarget(memo, diceIndex + 1, n, currSum + i, target, k));
        }

        return memo[diceIndex][currSum] = ways;
    }

    // really difficult, I don't really understand lol!!!!
    private static int waysToTargetBottomUp(int n) {
        return -1;
    }

    // the number of ways to roll n dices to get sum value equals to s
    // intuitive approach
    private static int algoMemo(int n, int k, int s) {
        int[][] memo = new int[n+1][s+1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return numRollsToTargetSecondIdea(memo, 0, n, k, 0, s);
    }

    private static int numRollsToTargetSecondIdea(int[][] memo, int diceIndex, int n, int k, int currentSum, int targetSum) {
        if (diceIndex == n) {
            return currentSum == targetSum ? 1 : 0;
        }

        if (memo[diceIndex][currentSum] != -1) {
            return memo[diceIndex][currentSum];
        }

        int ways = 0;
        for (int x = 1; x <= k; x++) {
            ways = ways + numRollsToTargetSecondIdea(memo, diceIndex + 1, n, k, currentSum + x, targetSum);
        }

        memo[diceIndex][currentSum] = ways;
        return memo[diceIndex][currentSum];
    }


    private static int numRollsToTargetIntuitive(int n, int k, int s) {
        if (s < 0) return 0;
        if (n == 0) {
            if (s == 0) return 1;
            else return 0;
        }
        int result = 0;
        for (int x = 1; x <= k; x++) {
            result = result + numRollsToTargetIntuitive(n - 1, k, s - x);
        }
        return result;
    }
}
