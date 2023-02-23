package Comp6651.Chapter4DynamicProgramming.LongestAlternatingSubsequence;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(las(nums));
    }

    public static int las(int[] nums) {
        // longest alternating sequence
        int n = nums.length;
        int[][] D = new int[n][2];
        D[0][0] = 1;
        D[0][1] = 1;
        for (int i = 1; i < n; i++) {
            D[i][0] = 1;
            D[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && D[j][1] + 1 > D[i][0]) {
                    D[i][0] = D[j][1] + 1;
                }
                if (nums[j] > nums[i] && D[j][0] + 1 > D[i][1]) {
                    D[i][1] = D[j][0] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (D[i][0] > max) {
                max = D[i][0];
            }
            if (D[i][1] > max) {
                max = D[i][1];
            }
        }
        return max;
    }
}
