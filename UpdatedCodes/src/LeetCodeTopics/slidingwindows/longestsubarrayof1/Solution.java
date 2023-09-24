package LeetCodeTopics.slidingwindows.longestsubarrayof1;

public class Solution {

    // Prev: Amazon, Apple and Yandex
    public static void main(String[] args) {
        var input = new int[]{1, 1, 0, 1};
        System.out.println(longestSubarray(input));
    }

    // Time: O(n)
    // Space: O(1)
    public static int longestSubarray(int[] nums) {
        int longestWindow = 0;
        int start = 0;
        int j = 0;
        int N = nums.length;
        int zeroCount = 0;
        for (; j < N; j++) {
            zeroCount += (nums[start] == 0 ? 1 : 0);

            // shrink the window until the zero counts come under the limit
            // invalid case based on template
            // keep shrinking the window until the zero counts come under the limit
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
            longestWindow = Math.max(longestWindow, j - start);
        }

        return longestWindow;
    }
}
