package neetcode150.slidingwindows.maxslidingwindows;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxSlidingWindows {
    public static void main(String[] args) {
        var nums = new int[] {1,3,-1,-3,5,3,6,7};
        var k = 3;
        var obj = new MaxSlidingWindows();
        var result = obj.maxSlidingWindowPQ(nums, k);
        for (var num : result) {
            System.out.println(num);
        }
    }

    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        var result = new ArrayList<Integer>();

        for (int i = 0; i <= nums.length - k; i++) {
            // find largest value from i to i + k
            var max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) max = nums[j];
            }

            result.add(max);
        }


        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    public int[] maxSlidingWindowPQ(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (nums[o2] - nums[o1]));

        for (int i = 0; i < n; i++) {
            int start = i - k;
            if (start >= 0) {
                maxPQ.remove(start);
            }
            maxPQ.offer(i);
            if (maxPQ.size() == k) {
                result[i-k+1] = nums[maxPQ.peek()];
            }
        }

        return result;
    }
}
