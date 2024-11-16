package neetcode150.slidingwindows.fixedwindowsize.substringwithconcatenatedofallwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringWithConcatenation {
    public static void main(String[] args) {

    }


    // TLE for large inputs
    public List<Integer> findSubstringTLE(String s, String[] words) {
        // generate all permutation of words concatenated
        var listWords = List.of(words);
        var permutations = generatePermutations(listWords);
        var result = new ArrayList<Integer>();
        for (var permuation : permutations) {
            var index = s.indexOf(permuation);
            while (index >= 0) {
                result.add(index);
                index = s.indexOf(permuation, index + 1);
            }
        }

        return result;
    }


    public static List<String> generatePermutations(List<String> words) {
        List<String> result = new ArrayList<>(words);
        List<String> finalResult = new ArrayList<>();
        Collections.sort(result); // Sort to start with the first permutation
        do {
            // Concatenate the current permutation into a single string
            StringBuilder concatenated = new StringBuilder();
            for (String word : result) {
                concatenated.append(word);
            }
            // Print the concatenated string
            finalResult.add(concatenated.toString());
        } while (nextPermutation(result));

        return finalResult;
    }

    // Helper function to generate the next permutation
    public static boolean nextPermutation(List<String> array) {
        int i = array.size() - 1;
        while (i > 0 && array.get(i - 1).compareTo(array.get(i)) >= 0) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = array.size() - 1;
        while (array.get(j).compareTo(array.get(i - 1)) <= 0) {
            j--;
        }

        Collections.swap(array, i - 1, j);

        j = array.size() - 1;
        while (i < j) {
            Collections.swap(array, i, j);
            i++;
            j--;
        }

        return true;
    }
}
