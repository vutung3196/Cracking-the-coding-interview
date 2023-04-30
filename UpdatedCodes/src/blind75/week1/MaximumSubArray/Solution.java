package blind75.week1.MaximumSubArray;

public class Solution {
    /***
     Given an integer array nums, find the contiguous subarray
     (containing at least one number)
     which has the largest sum and return its sum.
     A subarray is a contiguous part of an array.
     ***/
    public static int maxSubArray(int[] nums) {
        // max sub-array for A[i:j]
        // change the format of the problem to something like maxSubArray(int A[], int i)
        // max sub array for A[0:i]
        int n = nums.length;
        // dp[i] means the maximum subarray ending with A[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(input));
    }
}
