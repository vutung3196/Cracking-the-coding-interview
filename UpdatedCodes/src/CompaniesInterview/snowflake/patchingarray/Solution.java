package CompaniesInterview.snowflake.patchingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.concurrent.Executors;

public class Solution {
    public static void main(String[] args) {
        var numsA = new int[] {1, 2, 3, 4};
        var numsB = new int[] {2, 5, 6, 1, 1};
        var result = removeElements(numsA, numsB);
        for (var element : result) {
            System.out.println(element);
        }
    }

    public static List<Integer> removeElements(int[] numsA, int[] numsB) {
        // Add all elements in A to a Set
        var result = new ArrayList<Integer>();
        var numsASet = new HashSet<Integer>();
        for (var element : numsA) {
            numsASet.add(element);
        }
        int count = 0;
        // loop all elements in B, if set A contains => remove this element in B
        for (int i = 0; i < numsB.length; i++) {
            if (!numsASet.contains(numsB[i])) {
                result.add(numsB[i]);
           }
        }
        return result;
    }

    /**
    * Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
    Return the minimum number of patches required.
     */
    public static int minPatches(int[] nums, int n) {
        // any number in the range [1, n] inclusive can be formed by the sum of some elements in the array
        // miss is the smallest missing number, then we know that
        int patches = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (miss < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
}
