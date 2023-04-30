package blind75.week1.twosum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        var integerToIndex = new HashMap<Integer, Integer>();
        // push to the hash map -  value and index
        for (int i = 0; i < nums.length; i++) {
            integerToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            var remainingValue = target - nums[i];
            if (integerToIndex.containsKey(remainingValue) && integerToIndex.get(remainingValue) != i) {
                result[0] = integerToIndex.get(remainingValue);
                result[1] = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var nums = new int[]{3, 3};
        int target = 6;
        var result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
