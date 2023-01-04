package blind75.graph.longestconsecutivesequence;

import java.util.HashSet;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        var arr = new int[] {100,4,200,1,3,2};
        System.out.println(longestConsecutiveBruteForce(arr));
    }

    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * @param nums
     * @return int
     */
    public static int longestConsecutiveBruteForce(int[] nums) {
        // put all elements to a set (HashSet)
        var longestStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            var currentElement = nums[i];
            var currentStreak = 1;
            while (arrayContains(nums, currentElement+1)) {
                currentElement++;
                currentStreak+=1;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    private static boolean arrayContains(int[] arr, int num) {
        for (var element : arr) {
            if (element == num) return true;
        }
        return false;
    }

    /**
    Time complexity: O(n)
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum+1)) {
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
