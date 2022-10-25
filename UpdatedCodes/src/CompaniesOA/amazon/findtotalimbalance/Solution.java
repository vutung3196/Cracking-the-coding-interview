package CompaniesOA.amazon.findtotalimbalance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // link: https://cybergeeksquad.co/2022/10/find-total-imbalance-amazon-oa-2022.html
/**
 *
    Given an array of n elements find the count of imbalances in it. Imbalance is arr[i+1] - arr[i] > 1 in sorted array
    Example: arr = [2, 3, 1, 4]

 */


    public static void main(String[] args) {
        var a = new int[] {2, 3, 1, 4};
        var input = new ArrayList<Integer>() {};
        input.add(2);
        input.add(3);
        input.add(1);
        input.add(4);
        var result = getImbalanceBruteForce(input);
        System.out.println(result);
    }

    // get imbalance brute force
    // O(n^3. log(n))
    public static int getImbalanceBruteForce(List<Integer> ranks) {
        var result = 0;
        var size = ranks.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                var subArray = new ArrayList<Integer>();
                for (int k = i; k < j; k++) {
                    subArray.add(ranks.get(k));
                }
                Collections.sort(subArray);
                for (int k = 1; k < subArray.size(); k++) {
                    if (subArray.get(k) - subArray.get(k - 1) > 1) {
                        result += 1;
                    }
                }
            }
        }

        return result;
    }
}
