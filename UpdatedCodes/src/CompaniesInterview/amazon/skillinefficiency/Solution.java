package CompaniesInterview.amazon.skillinefficiency;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    // review https://leetcode.com/problems/find-k-th-smallest-pair-distance/solutions/127408/find-k-th-smallest-pair-distance/
    public static void main(String[] args) {
        var skills = new int[] {6, 9, 1};
        var k = 2;
        var result = getSmallestInefficiencyBruteForce(skills, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    // will not work for large array
    private static int[] getSmallestInefficiencyBruteForce(int[] skills, int k) {
        var result = new int[k];
        // loop through all elements in skills
        var result1 = new ArrayList<Integer>();
        // find all the difference
        for (int i = 0; i < skills.length; i++) {
            for (int j = i + 1; j < skills.length; j++) {
                var currentDiff = Math.abs(skills[j] - skills[i]);
                result1.add(currentDiff);
            }
        }

        Collections.sort(result1);
        for (int i = 0; i < k; i++) {
            result[i] = result1.get(i);
        }

        return result;
    }


    // review solutions from Leetcode!
    private static int[] getSmallestInEfficiency(int[] skills, int k) {
        return new int[10];
    }


}
