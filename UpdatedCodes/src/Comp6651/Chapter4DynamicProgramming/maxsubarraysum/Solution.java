package Comp6651.Chapter4DynamicProgramming.maxsubarraysum;

public class Solution {
    public static void main(String[] args) {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        var result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
