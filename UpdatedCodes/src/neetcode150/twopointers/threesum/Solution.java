package neetcode150.twopointers.threesum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        var obj = new Solution();
        var result = obj.threeSumIdea(new int[] {-1,0,1,2,-1,-4});
        for (var list : result) {
            for (var num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // finding all indexes
        // find all i, j, and k: nums[i] + nums[j] + nums[k] = 0;
        // nums[i] + nums[j] = -nums[k]
        var result = new ArrayList<List<Integer>>();
        var map = new HashMap<Integer, Integer>();
        for (var num : nums) {
            var currentValue = map.getOrDefault(num, 0);
            map.put(num, currentValue + 1);
        }

        for (int num : nums) {
            // find all j, k where nums[j] + nums[k] = -nums[i]
            var target = -num;
            var resultTwoSum = twoSum(nums, target, map);
            if (!resultTwoSum.isEmpty()) {
                resultTwoSum.add(num);
                result.add(resultTwoSum);
            }
        }


        return result;
    }

    public List<List<Integer>> threeSumIdea(int[] nums) {
        // Sort array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // Use HashMap to store potential pairs

            int target = -nums[i];

            // finding all pairs that sum to target
            Map<Integer, Integer> seen = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (seen.containsKey(complement)) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], complement, nums[j]));

                    // skip duplicates for j
                    while (j  + 1 < nums.length && nums[j] == nums[j+1]) {
                        j++;
                    }
                }

                seen.put(nums[j], j);
            }
        }

        return result;
    }

    public List<List<Integer>> threeSumSet(int[] nums) {
        var result = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;

            while (mid < right) {
                var sum = nums[left] + nums[mid] + nums[right];
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


    List<Integer> twoSum(int[] nums, int target, Map<Integer, Integer> map) {
        var result = new ArrayList<Integer>();
        for (int current : nums) {
            if (map.containsKey(target - current)) {
                result.add(current);
                result.add(target - current);
                return result;
            }
        }

        return result;
    }
}
