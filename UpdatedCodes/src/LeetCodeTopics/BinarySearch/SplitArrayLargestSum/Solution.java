package LeetCodeTopics.BinarySearch.SplitArrayLargestSum;

public class Solution {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean feasible(int[] nums, int k, int threshold) {
        int total = 0;
        int count = 1;
        for (int num : nums) {
            total += num;
            if (total > threshold) {
                total = num;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }

        return true;
    }
}
