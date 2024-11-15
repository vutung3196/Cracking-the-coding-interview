package neetcode150.slidingwindows.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // four sum
        var obj = new Solution();
        var result = obj.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
        for (var list : result) {
            for (var num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == nums.length) return result;

        long averageValue = target / k;
        if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) return result;

        if (k == 2) {
            return twoSumCall(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i-1]) {
                var subsetList = kSum(nums, target - nums[i], i + 1, k - 1);
                for (var subset : subsetList) {
                    result.add(new ArrayList<>(List.of(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
            }
        }

        return result;
    }

    private List<List<Integer>> twoSumCall(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int low = start;
        int high = nums.length - 1;

        while (low < high) {
            int curr = nums[low] + nums[high];

            if (curr == target) {
                var newlyAdded = Arrays.asList(nums[low], nums[high]);
                res.add(newlyAdded);
                low++;
                high--;

                // Skip duplicates
                while (low < high && nums[low] == nums[low - 1]) low++;
                while (low < high && nums[high] == nums[high + 1]) high--;
            }
            else if (curr < target) {
                low++;
            } else {
                high--;
            }
        }

        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
}
