package CompaniesInterview.amazon.optimizingboxweight;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // partition it into two subsets
        int[] input = new int[] {4, 5, 2, 3, 2};
        var result = optimize(input);
        for (var element: result) {
            System.out.println(element);
        }
    }

    private static int[] optimize(int[] arr) {
        // Find the sum => find the max Sum can achieve
        // moving from idx to idx
        long arraySum = 0;
        for (int number: arr) {
            arraySum += number;
        }

        Arrays.sort(arr);
        long max = 0;
        int idx = 0;

        while (idx < arr.length && max * 2 < arraySum) {
            max += arr[idx];
            idx++;
        }

        // idx now is the first element of box A
        idx--;
        int[] res = new int[arr.length - idx];
        for (int i = 0; i < arr.length - idx; i++) {
            res[i] = arr[idx + i];
        }

        return res;
    }

}
