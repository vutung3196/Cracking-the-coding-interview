package neetcode150.slidingwindows.fixedwindowsize.substringwithconcatenatedofallwords;

import java.util.*;

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

    // O(n . m . k)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        Map<String, Integer> wordsCount = new HashMap<>();

        // Count frequency of each word
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        // check each position starting position in s
        // window size: totalLen
        for (int start = 0; start <= s.length() - totalLen; start++) {
            // Count of words seen in current windows
            Map<String, Integer> seen = new HashMap<>();
            boolean valid = true;

            // Check each word position in the current window
            for (int j = 0; j < totalLen; j+= wordLen) {
                String currWord = s.substring(start + j, start + j + wordLen);

                // if word is not in original list or we've used too many instances
                if (!wordsCount.containsKey(currWord)) {
                    valid = false;
                    break;
                }

                // Update count of seen words
                seen.put(currWord, seen.getOrDefault(currWord, 0) + 1);
                if (seen.get(currWord) > wordsCount.get(currWord))
                {
                    valid = false;
                    break;
                }

            }

            if (valid) {
                result.add(start);
            }
        }

        return result;
    }

    public List<Integer> findSubstringOptimized(String s, String[] words) {
        return null;
        // difficult to implement, will take a look at that later on
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
