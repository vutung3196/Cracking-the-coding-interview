package Chapter4DynamicProgramming.LongestConvexSubsequence;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        var input = new int[] {0, 3, 7, 8, 13};
        var input2 = new int[] {  10,
                32,
                75,
                43,
                42,
                27,
                27,
                77,
                10,
                4,
                74};
        var input3 = new int[] {1, 2, 5, 7, 9, 10, 12};
        var input4 = new int[] { 1, 2, -1, 0, 3, 8, 5 };
        longestConvexSubsequence(input);
        System.out.println("*****");
        longestConvexSubsequence(input2);
        System.out.println("*****");
        longestConvexSubsequence(input3);
        System.out.println("**********************************");
        System.out.println(longestConvexSubsequence(input));
        System.out.println(longestConvexSubsequence(input2));
        System.out.println(longestConvexSubsequence(input3));
        System.out.println(longestConvexSubsequence(input4));
        System.out.println("================");
        System.out.println(longestConvexSubsequenceFrom0Index(input));
        System.out.println(longestConvexSubsequenceFrom0Index(input2));
        System.out.println(longestConvexSubsequenceFrom0Index(input3));
        System.out.println(longestConvexSubsequenceFrom0Index(input4));
    }

    public static int longestConvexSubsequence(int[] A) {
        int result = 0;
        // B[i][j] is the length of the longest convex subsequence where first two elements are A[i] and A[j]
        // Result: Max(B[i][j])
        int[][] B = new int[A.length][A.length];
        int[] longestSubsequence = new int[0];
        var b = new ArrayList<ArrayList<Integer>>();
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A.length - 1; j >= i+1; j--) {
                B[i][j] = 2;
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[k] > 2 * A[j]) {
                        B[i][j] = Math.max(B[i][j], 1 + B[j][k]);
                    }
                }
                if (result < B[i][j]) {
                    result = B[i][j];
//                    longestSubsequence = new int[result];
//                    longestSubsequence[0] = A[i];
//                    longestSubsequence[1] = A[j];
//                    int index = 2;
//                    for (int k = j + 1; k < A.length; k++) {
//                        if (A[j] + A[k] > 2 * longestSubsequence[index - 1] && B[j][k] == result - 2) {
//                            longestSubsequence[index] = A[k];
//                            index++;
//                            j = k;
//                            break;
//                        }
//                    }
//                    for (int k = j + 1; k < A.length && index < result; k++) {
//                        if (A[j] + A[k] > 2 * longestSubsequence[index - 1]) {
//                            longestSubsequence[index] = A[k];
//                            index++;
//                            j = k;
//                        }
//                    }
//                    System.out.println("=============================");
//                    for (var element : longestSubsequence) {
//                        System.out.print(element + " || ");
//                    }
                }
            }
        }

        return result;
    }

    public static int longestConvexSubsequenceFrom0Index(int[] A) {
        int result = 0;
        int[][] dp = new int[A.length][A.length];
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = 2;
                for (int k = 0; k < j; k++) {
                    if (((A[i] + A[k] > (A[j] * 2)))) {
                        dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }


}
