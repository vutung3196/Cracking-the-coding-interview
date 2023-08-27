package LeetCodeTopics.TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            // solving two sum problem
            int mid = left+1;
            int right = nums.length-1;
            // finding two numbers where target having value -num
            //
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    var newList = new ArrayList<Integer>();
                    newList.add(nums[left]);
                    newList.add(nums[mid]);
                    newList.add(nums[right]);
                    result.add(newList);
                    mid++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
