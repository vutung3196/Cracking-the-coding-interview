package Comp6651.Chapter4DynamicProgramming.LongestDecreasingSubsequence;

public class Solution {
    public static void main(String[] args) {
        var nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
        var result = lds(nums);
        System.out.println(result);
    }

    public static int lds(int[] nums) {
        // D[i]: length of lds starting from number nums[i], should include nums[i]
        int[] D = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            D[i] = 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i] && D[j] + 1 > D[i]) {
                    D[i] = 1 + D[j];
                }
            }
        }
        var max = 0;
        for (int j : D) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
