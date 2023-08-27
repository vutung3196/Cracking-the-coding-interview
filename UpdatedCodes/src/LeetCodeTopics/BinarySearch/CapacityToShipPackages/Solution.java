package LeetCodeTopics.BinarySearch.CapacityToShipPackages;

public class Solution {
    public static void main(String[] args) {

    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean feasible(int[] weights, int days, int mid) {
        int total = 0;
        int day = 1;
        for (int weight : weights) {
            total += weight;
            if (total > mid) {
                total = weight;
                day++;
                if (day > days) {
                    return false;
                }
            }
        }

        return true;
    }


}
