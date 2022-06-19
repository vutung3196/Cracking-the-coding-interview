package Chapter13HashTables.ExerciseFindAnagrams;

import java.util.*;

public class Solution {
    /**
     * Time complexity - O(m*n*log(m))
     * @param dictionary
     * @return
     */
    public static List<List<String>> findAnagrams(List<String> dictionary) {
        List<List<String>> result = new ArrayList<>();
        // using hash map with key: sorted String, value: Linked list of strings
        // put and update
        Map<String, List<String>> KeyToListAnagram = new HashMap<>();
        for (String word : dictionary) {
            var wordCharacters = word.toCharArray();
            Arrays.sort(wordCharacters);
            var sortedWord = new String(wordCharacters);
            if (!KeyToListAnagram.containsKey(sortedWord)) {
                KeyToListAnagram.put(sortedWord, new ArrayList<>());
            }
            KeyToListAnagram.get(sortedWord).add(word);
        }
        for (var strings : KeyToListAnagram.values()) {
            if (strings.size() > 1) result.add(strings);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("debitcard");
        dictionary.add("badcredit");
        dictionary.add("elvis");
        dictionary.add("silent");
        dictionary.add("lives");
        dictionary.add("freedom");
        dictionary.add("listen");
        dictionary.add("levis");
        dictionary.add("money");
        var a = findAnagrams(dictionary);
        for (var b : a) {
            for (var c : b) {
                System.out.println(c);
            }
        }
    }
}
