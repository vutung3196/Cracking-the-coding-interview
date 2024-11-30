package CompaniesInterview.affirm;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // dp[i] = minimum number of coins where sum up to i
        // return dp[amount]
        for (int upto = 1; upto <= amount; upto++) {
            for (int i = 0; i < coins.length; i++) {
                var current = dp[upto - coins[i]] + 1;
                dp[upto] = Math.min(current, dp[upto]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
