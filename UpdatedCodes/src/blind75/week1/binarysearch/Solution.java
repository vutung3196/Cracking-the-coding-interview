package blind75.week1.binarysearch;

public class Solution {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < nums[mid]) {
                high--;
            } else if (target > nums[mid]) {
                low++;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
