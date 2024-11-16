package neetcode150.slidingwindows.fixedwindowsize.substringwithconcatenatedofallwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordsPermutation {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana");
        generatePermutations(words);
    }

    public static void generatePermutations(List<String> words) {
        List<String> result = new ArrayList<>(words);
        Collections.sort(result); // Sort to start with the first permutation
        do {
            // Concatenate the current permutation into a single string
            StringBuilder concatenated = new StringBuilder();
            for (String word : result) {
                concatenated.append(word);
            }
            // Print the concatenated string
            System.out.println(concatenated.toString());
        } while (nextPermutation(result));
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
