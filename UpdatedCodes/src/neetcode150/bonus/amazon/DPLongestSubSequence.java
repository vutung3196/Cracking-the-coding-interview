package neetcode150.bonus.amazon;

import java.util.*;

public class DPLongestSubSequence {
    public static void main(String[] args) {
        var f1 = new Integer[]{3, 2, 1, 4, 6, 5};
        var obj = new DPLongestSubSequence();
        System.out.println((obj.exceedingThreshold(f1, 3, 14)));
        System.out.println("lol");
    }

    // features
    // Two co-related features, features are represented as two arrays of n integer each.
    // feature1[] and feature2[]
    // outliers if: for any i and j 0 <= i < j <= n;
    // we have feature1[i] > feature1[j] -> feature2[i] > feature2[j]
    // or feature1[i] < feature1[j] -> feature2[i] < feature2[j]
    // find the length of the largest array of indices i1, i2, i3,...,ik such that
    // data for feature1 and feature2
    // Suppose for n = 5, feature1 = [4, 5, 3, 1, 2], feature2 = [2, 1, 3, 4, 5]; the answer is 2
    // since we pick the index [3, 4]
    public static int getLargestIndexLen(int[] f1, int[] f2) {
        // longest subsequence
        // DP array: dp[i]: length of the longest valid sequence ending at index i
        int[] dp = new int[f1.length];
        int n = f1.length;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((f1[i] < f1[j] && f2[i] < f2[j])
                        || f1[i] > f1[j] && f2[i] > f2[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (var element : dp) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    // n customer requests placed sequentially in a queue,
    //    // where ith request has a maximum waiting time denoted by wait[i]
    //    // if the ith request is not served within wait[i] seconds, then the request expires
    //    // and it is removed from the queue. The server processes FIFO, 1st request is processed first
    //    // and the nth request is served last. At each second, the first request in the queue is processed.
    //    // At the next second, the processed request and any expired requests are removed from the queue.
    //    // Given the maximum waiting time of each request denoted by the array wait, find the number of requests
    //    // present in the queue at every second until it is empty.
    //    // if a request is served at sometime instant t, it will be counted for that instant and is removed at the next
    //    // instant
    //    // The first request is processed at time = 0. A request is expired without being processed when time = wait[i]
    //    // it must be processed while time < wait[i]
    //    // The initial queue represents all requests at time = 0 in the order they must be processed.
    //    // The number of requests is n = 4, their maximum wait times are wait [2,2,3,1] => answer is [4,2,1,0]
    public static int[] processRequests(int[] wait) {
        int n = wait.length;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        // Initialize the queue with indices of requests
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            result.add(queue.size());
            // Process the first request in the queue
            int request = queue.poll();
            // Increment time after processing
            time++; // Remove expired requests
            while (!queue.isEmpty() && wait[queue.peek()] <= time) {
                queue.poll();
            }
        }
        // Convert result list to array
        return result.stream().mapToInt(i -> i).toArray();
    }

    // find the longest subarray with at most k zeros
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int numZeroes = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                numZeroes++;
            }
            if (nums[left] == 0) {
                numZeroes--;
                left++;
            }
            if (numZeroes <= k) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    // Determine the minimum number of items to remove from an array of prices
    // so that the sum of prices for any k items does not exceed a threshold
    public int findMin(int[] prices, int k, int threshold) {
        int left = 0, right = 0;
        int len = prices.length;
        Arrays.sort(prices);
        int count = 0;
        int cSum = 0;
        // sort the array then move from the right
        for (right = 0; right < len; right++) {
            cSum += prices[right];
            if (right - left + 1 == k) {
                if (cSum <= threshold) return count;
                else {
                    count += 1;
                    cSum -= prices[left];
                    left += 1;
                }
            }
        }

        return count;
    }

    public int exceedingThreshold(Integer[] prices, int k, int threshold) {
        if (prices.length < k) {
            return 0;
        }

        Arrays.sort(prices, Collections.reverseOrder());
        int count = 0, left = 0, cSum = 0;
        for (int right = 0; right < prices.length; right++) {
            cSum += prices[right];
            if (right - left + 1 == k) {
                if (cSum <= threshold) {
                    return count;
                } else if (cSum > threshold) {
                    count += 1;
                    cSum -= prices[left];
                    left += 1;
                }
            }
        }

        return count;
    }

    // Given an unsorted array of integers with duplicates and integer m and integer k.
    // Find the kth minimum element of all the contiguous subarray whose length is m.
//    public List<Integer> kthSmallestInWindows(int[] arr, int k, int m) {
//
//    }

    // DNA sequence
    // In the given problem, analysing a string that represents a DNA sequence
    // A DNA sequence consists of a series nucleotites
    // A, C, G, and T.
    // finding all the unique substring of length 10 that repeat more than once within this DNA sequence

}
