package neetcode150.array.longestconsecutivesubsequence;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * @param nums
     * @return int
     */
    public static int longestConsecutiveSubsequentBruteForce(int[] nums) {
        var longestStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            var currentElement = nums[i];
            var currentStreak = 1;

            while (arrayContains(nums, currentElement + 1)) {
                currentStreak++;
                currentElement++;
            }

            longestStreak = Math.max(currentStreak, longestStreak);
        }

        return longestStreak;
    }

    public static int longestConsecutiveSubsequent(int[] nums) {
        var setElements = new HashSet<Integer>();
        for (var num : nums) {
            setElements.add(num);
        }

        var longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            var currentElement = nums[i];
            var currentStreak = 1;

            while (setElements.contains(currentElement+1)) {
                currentStreak++;
                currentElement++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    static boolean arrayContains(int[] nums, int value) {
        for (var num : nums) {
            if (num == value) {
                return true;
            }
        }

        return false;
    }
}
