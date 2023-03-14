package Comp6651.Chapter4DynamicProgramming.LongestIncreasingSubsequence;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6};
        System.out.println(new Solution().lengthOfLIS(nums));
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
}
