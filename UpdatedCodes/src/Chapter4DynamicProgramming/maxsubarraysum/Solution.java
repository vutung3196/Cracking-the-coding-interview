package Chapter4DynamicProgramming.maxsubarraysum;

public class Solution {
    public static void main(String[] args) {
        var nums = new int[]{-6, 12,-7, 0, 14,-7, 5};
        var result = maxSubArrayProduct(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1 && nums[0] < 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArrayProduct(int[] nums) {
        int n = nums.length;
        int[] maxSoFar = new int[nums.length];
        int[] minSoFar = new int[nums.length];
        maxSoFar[0] = nums[0];
        minSoFar[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            maxSoFar[i] = Math.max(nums[i], Math.max(maxSoFar[i-1] * nums[i], minSoFar[i-1] * nums[i]));
            minSoFar[i] = Math.min(nums[i], Math.min(maxSoFar[i-1] * nums[i], minSoFar[i-1] * nums[i]));
            if (maxSoFar[i] > result) result = maxSoFar[i];
        }

        return result;
    }

    public static int maxSubArrayProductBruteForce(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }
}
