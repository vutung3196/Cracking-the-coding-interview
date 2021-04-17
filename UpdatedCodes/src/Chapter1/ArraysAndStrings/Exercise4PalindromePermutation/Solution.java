package Chapter1.ArraysAndStrings.Exercise4PalindromePermutation;


import java.util.HashMap;
import java.util.Locale;

/**
 * Palindrome permutation: given a string, write a function to check
 * if it is a permutation of a palindrome.
 * input: Tact Coa
 * output: True (permutations: "taco cat", "atco cta", etc.)
 */
public class Solution {
    private static boolean isPermutationOfAPalindrome(String input) {
        var inputArray = input.toLowerCase().toCharArray();
        // or using build char frequency number
        var charToCount = new HashMap<Character, Integer>();
        for(char character : inputArray) {
            if (character == ' ') continue;
            if (!charToCount.containsKey(character)) {
                charToCount.put(character, 1);
            } else {
                charToCount.put(character, charToCount.get(character) + 1);
            }
        }
        boolean foundOdd = false;
        for(int count : charToCount.values()) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfAPalindrome("Tact Coa"));
        System.out.println(isPermutationOfAPalindrome("abc"));
        System.out.println(isPermutationOfAPalindrome("abba"));
        System.out.println(isPermutationOfAPalindrome("aabbb"));
        System.out.println(isPermutationOfAPalindrome("aabbde"));
    }
}
