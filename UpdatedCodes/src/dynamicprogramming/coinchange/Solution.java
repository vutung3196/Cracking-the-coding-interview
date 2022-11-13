package dynamicprogramming.coinchange;

import java.util.Arrays;

public class Solution {

    /**
     * You are given an integer array coins representing coins of
     * different denominations and an integer amount representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * You may assume that you have an infinite number of each kind of coin.
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int target) {
        // using recursion here
        // f(i, s) = min(f(i - 1, s), f(i - 1, s - coins[i]))
        // khong lay i thi f(i-1, s)
        // lay i thi f(i - 1, s - coins[i])
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {
            }
        }
        return -1;
    }

    public static int coinChangeBruteForce(int[] coins, int target) {
        return coinChangeBruteForceVersion(0, coins, target);
    }

    private static int coinChangeBruteForceVersion(int idxCoin, int[] coins, int target) {
        // coin frequencies [x0, x1,..., x(n-1)]
        if (target == 0) return 0;
        if (idxCoin < coins.length && target > 0) {
            int maxNumberOfCoins = target / coins[idxCoin];
            // initialize the minimum number of coins
            int minimumNumberOfCoins = Integer.MAX_VALUE;
            for (int number = 0; number < maxNumberOfCoins; number++) {
                if (target >= number * coins[idxCoin]) {
                    int res = coinChangeBruteForceVersion(idxCoin + 1, coins, target - number * coins[idxCoin]);
                    if (res != -1)
                        minimumNumberOfCoins = Math.min(minimumNumberOfCoins, res + number);
                }
            }
            return (minimumNumberOfCoins == Integer.MAX_VALUE) ? -1 : minimumNumberOfCoins;
        }
        return -1;
    }

    public int coinChangeOptimal(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        if (count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int res = coinChange(coins, rem, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int max = amount + 1;
        // remember the solution for each sum
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
