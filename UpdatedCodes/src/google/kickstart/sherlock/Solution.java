package google.kickstart.sherlock;

import java.util.*;

/***
 * Sherlock and Watson have recently enrolled in a computer programming course.
 * Today, the tutor taught them about the balanced parentheses problem.
 * A string S consisting only of characters ( and/or ) is balanced if:
 * It is an empty string, or:
 * It has the form (S), where S is a balanced string, or:
 * It has the form S1S2, where S1 is a balanced string and S2 is a balanced string.
 */
public class Solution {

    private static long findMaxNumOfBalancedSubstrings(int l, int r) {
        long maxNumOfSubstrings = 0;
        // found the maximum number of balanced sub strings
        // s is 
        // TODO: Add logic to find the maximum possible number of balanced non-empty substrings
        return maxNumOfSubstrings;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Input number of test cases
        int testCaseCount = in.nextInt();
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Input total number of left and right parentheses
            int l = in.nextInt();
            int r = in.nextInt();

            System.out.println("Case #" + tc + ": " + findMaxNumOfBalancedSubstrings(l, r));
        }
    }
}
