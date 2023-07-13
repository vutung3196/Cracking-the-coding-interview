package LeetCodeTopics.slidingwindows.longestsubarrayof1;

public class Solution {
    public static void main(String[] args) {
        var input = new int[]{1, 1, 0, 1};
        System.out.println(longestSubarray(input));
    }

    public static int longestSubarray(int[] nums) {
        int longestWindow = 0;
        int zeroCount = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);

            // shrink the window until the zero counts come under the limit
            // invalid case based on template
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }
}
