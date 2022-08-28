package BlindList.Week1.Array.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    // Given an array of integers nums and an integer target,
    // return indices of the two numbers such that they add up to target.
    // Sub-array - A range of continuous values within an array.
    // Sub-sequence - A sequence that can be derived from the given sequence by deleting
    // some or no elements without changing the order of the remaining elements.
    // two pointers
    public static int[] twoSum(int[] nums, int target) {
        var value_to_index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            value_to_index.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (value_to_index.containsKey(target - nums[i]) && i != value_to_index.get(target-nums[i])) {
                return new int[]{i, value_to_index.get(target - nums[i])};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        var nums = new int[]{3, 2, 4};
        int target = 6;
        var result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
