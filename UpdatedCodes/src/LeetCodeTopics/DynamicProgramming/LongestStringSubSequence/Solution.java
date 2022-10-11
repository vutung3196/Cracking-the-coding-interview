package LeetCodeTopics.DynamicProgramming.LongestStringSubSequence;

import java.util.Collections;
import java.util.List;

public class Solution {
    /***
     * Given two strings A and B, find a longest (not necessarily contiguous) subsequence of A
     * that is also a subsequence of B.
     * Example: A = hieroglyphology, B = michaelangelo
     * Solution: Hello
     * @param args
     */
//    public int ReturnTheLongestSubsequence(String A, String B) {
//        int a = A.length();
//        int b = B.length();
//        int[] x = new int[a+1];
//        for (int i = 0; i < a + 1; i++) {
//            x[i] = [0, ]
//        }
//        return 1;
//    }

    public static void printRandom() {
        int j = 0;
        for (int i = 3; i < 7; i++) {
            if (i > 4) {
                j = j + i;
            }
        }

        System.out.println(j);
    }

    public static int addFun(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 2;
        }

        return addFun(n - 1) + addFun(n - 2);
    }

    public static List<Integer> merge(List<Integer> nums1, List<Integer> nums2) {
        nums1.addAll(nums2);
        Collections.sort(nums1);
        return nums1;
    }

    public static void main(String[] args) {
        printRandom();
        System.out.println(addFun(6));
    }
}
