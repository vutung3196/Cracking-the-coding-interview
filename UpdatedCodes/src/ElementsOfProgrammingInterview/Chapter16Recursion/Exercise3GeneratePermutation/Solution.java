package ElementsOfProgrammingInterview.Chapter16Recursion.Exercise3GeneratePermutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Write a program which takes as input an array of distinct integers and generates all
    // permutations of that array. No permutation of the array may appear more than once.
    private static List<List<Integer>> GeneratePermutations(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        directedPermutation(0, input, result);
        return result;
    }

    private static void directedPermutation(int start, List<Integer> A, List<List<Integer>> result) {
        if (start == A.size() - 1) {
            result.add(new ArrayList<>(A));
            return;
        }

        for (int j = start; j < A.size(); j++) {
            Collections.swap(A, start, j);
            // Generate all permutations for A.sublist(i + 1, A.size());
            directedPermutation(start+1, A, result);
            Collections.swap(A, start, j);
        }
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(5);
        input.add(7);
        var result = GeneratePermutations(input);
        System.out.println(result.size());
        System.out.println("===========================");
        for (var listResult : result) {
            for (var element : listResult) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
