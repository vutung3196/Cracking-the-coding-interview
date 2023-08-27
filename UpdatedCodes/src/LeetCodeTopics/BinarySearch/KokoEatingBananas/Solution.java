package LeetCodeTopics.BinarySearch.KokoEatingBananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        System.out.println();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    // whether Koko can finish all piles within h hours with threshold having value threshold
    public boolean feasible(int[] piles, int h, int speed) {
        int totalHours = 0;
        for (var pile : piles) {
            totalHours += (pile - 1) / speed + 1;
        }

        return totalHours <= h;
    }
}
