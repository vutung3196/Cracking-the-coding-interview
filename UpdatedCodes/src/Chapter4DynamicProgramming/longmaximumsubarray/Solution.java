package Chapter4DynamicProgramming.longmaximumsubarray;

public class Solution {
    public static void main(String[] args) {

    }

    public static int maximumSubArrayLengthAtLeastK(int[] nums, int k) {
        // return sum
        int[] dp = new int[nums.length];
        // idea finding the maximum subarray in nums ending at nums[i]
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }

        // got all the dp[i]
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int result = sum;
        // running the k windows
        for (int i = k; i < nums.length; i++) {
            // max sum ending with nums[i]
            sum = sum + nums[i] - nums[i-k];

            // Update the result
            result = Math.max(result, sum);

            // including from sum of maxSubArray from index: [i-k]
            result = Math.max(result, sum + dp[i-k]);
        }

        return result;
    }
}
