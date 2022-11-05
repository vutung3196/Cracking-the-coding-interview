package dynamicprogramming.coinchange;

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


}
