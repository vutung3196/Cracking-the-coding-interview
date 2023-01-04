package CompaniesInterview.snowflake.patchingarray;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

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

    public static int minPatches(int[] nums, int n) {

    }
}
