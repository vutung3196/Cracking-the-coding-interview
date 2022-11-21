package CompaniesInterview.amazon.countcharacters;

// Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/solutions/

import java.util.Arrays;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 */
public class Solution {
    public static void main(String[] args) {
        var words = new String[] {"cat","bt","hat","tree"};
        var chars = "atach";

        // expect 6
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        // leveraging the int[26] to calculate the occurrence
        int[] occurrenceCharacterArray = new int[26];

        // put it in the occurrence array
        for (char character : chars.toCharArray()) {
            occurrenceCharacterArray[character - 'a'] += 1;
        }

        // loop through all the words
        for (String word : words) {
            // making a copy of the occurrenceArray
            int[] copiedOccurrenceArray = Arrays.copyOf(occurrenceCharacterArray, 26);
            int tCount = 0;

            // checking the word array
            for (char character : word.toCharArray()) {
                // found
                // if found --1
                if (copiedOccurrenceArray[character - 'a'] > 0) {
                    copiedOccurrenceArray[character - 'a'] -= 1;
                    tCount++;
                }
            }

            if (tCount == word.length()) {
                count += tCount;
            }
        }

        return count;
    }
}
