package Chapter4DynamicProgramming.IntervalSchedulingRevisited;

public class Solution {
    public static void main(String[] args) {
        var start = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        var finish = new int[]{4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        var value = new int[]{3, 4, 1, 5, 6, 8, 8, 2, 12, 4, 5};
        var result = weightedIntervalScheduling(start, finish, value);
        System.out.println(result);

    }

    public static int weightedIntervalScheduling(int[] start, int[] finish, int[] value) {
        int n = start.length;
        int[] dp = new int[n];
        dp[0] = value[0];
        for (int i = 1; i < n; i++) {
            int m = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (finish[j] <= start[i] && dp[j] > m) {
                    m = dp[j];
                }
            }
            dp[i] = Math.max(value[i] + m, dp[i - 1]);
        }

        for (var element : dp) {
            System.out.println(element);
        }
        return dp[n - 1];
    }
}
