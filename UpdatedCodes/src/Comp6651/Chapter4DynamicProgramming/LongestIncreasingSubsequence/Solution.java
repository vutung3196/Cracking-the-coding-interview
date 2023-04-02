package Comp6651.Chapter4DynamicProgramming.LongestIncreasingSubsequence;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[] {1,2,3,4,5,6};
//        System.out.println(new Solution().lengthOfLIS(nums));
        System.out.println(lengthOfLISReverse("carbohydrate"));
    }

    public int lengthOfLIS(int[] nums) {
        int[] D = new int[nums.length];
        D[0] = 1;
        for (int i = 1; i < nums.length ; i++) {
            int m = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i] && D[j] > m) {
                    m = D[j];
                }
            }
            D[i] = 1 + m;
        }
        var max = 0;
        for (var element : D) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int lengthOfLISReverse(String A) {
        // dp[i]: length of longest increasing subsequence for A[i:] and includes A[i]
        // return max(dp)
        int[] dp = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            dp[i] = 1;
        }

        for (int i = A.length() - 1; i >= 0; i--) {
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) > A.charAt(i)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        var max = 0;
        for (var element : dp) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

//    public static int lengthOfLISTIntuitive(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//
//        }
//    }
}
