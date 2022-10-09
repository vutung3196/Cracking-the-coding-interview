package Chapter1.ArraysAndStrings.Exercise2CheckPermutation;


import java.util.Arrays;

/**
 * Given two strings, write a method
 * to decide if one is a permutation of the other
 * for example "abc" is the permutation of "bca"
 */
public class Solution {
    /**
     * Step 1: sort two strings
     * Step 2: compare each character in two strings
     *
     * @param s1: input 1
     * @param s2: input 2
     * @return
     */
    private static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        // sort 2 strings
        var s1CharArray = s1.toCharArray();
        var s2CharArray = s2.toCharArray();
        sortCharArray(s1CharArray);
        sortCharArray(s2CharArray);

        for (int i = 0; i < s1.length(); i++) {
            // compare
            if (s1CharArray[i] != s2CharArray[i])
                return false;
        }
        return true;
    }

    private static void sortCharArray(char[] input) {
        Arrays.sort(input);
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "bac"));
        System.out.println(isPermutation("abc", "bad"));
    }
}
