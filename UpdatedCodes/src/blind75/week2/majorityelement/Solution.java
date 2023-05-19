package blind75.week2.majorityelement;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        var compareValue = Math.floor(nums.length / 2);
        var numberToCount = new HashMap<Integer, Integer>();
        for (var element : nums) {
            var currentCount = numberToCount.getOrDefault(element, 0);
            numberToCount.put(element, currentCount + 1);
        }

        for (var key : numberToCount.keySet()) {
            if (numberToCount.get(key) > compareValue) {
                return key;
            }
        }

        return -1;
    }
}
