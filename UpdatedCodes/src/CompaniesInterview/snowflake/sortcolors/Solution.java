package CompaniesInterview.snowflake.sortcolors;

public class Solution {
    public static void main(String[] args) {
    }

    // Input: nums = [2,0,2,1,1,0]
    // Output: [0,0,1,1,2,2]
    // O(n^2) time complexity
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }

    // O(n) time complexity
    public void sortColors1Pass(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        int curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                int temp = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = temp;
                curr++;
                p0++;
            } else if (nums[curr] == 2) {
                int temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else if (nums[curr] == 1) {
                curr++;
            }
        }
    }
}