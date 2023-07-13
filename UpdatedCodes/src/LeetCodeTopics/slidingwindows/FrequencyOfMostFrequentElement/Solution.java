package LeetCodeTopics.slidingwindows.FrequencyOfMostFrequentElement;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, N = nums.length, ans = 1, sum = 0;
        for (int j = 0; j < N; j++) {
            sum += nums[j];
            // valid (j-i+1): number of operations
            // nums[j] to reach nums[j] value
            // (j-i+1) *nums[j] - sum: number of operations
            // invalid case, technically you cannot reach the number nums[j]
            while ((j - i + 1) * nums[j] - sum > k) {
                sum -= nums[i];
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
