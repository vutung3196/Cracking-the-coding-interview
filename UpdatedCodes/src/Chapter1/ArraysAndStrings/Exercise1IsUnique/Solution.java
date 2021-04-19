package Chapter1.ArraysAndStrings.Exercise1IsUnique;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static boolean isUniqueByUsingHashTable(String input) {
        // hashTable approach
        Map<Character, Integer> characterToCount = new HashMap<>();
        for (Character character : input.toCharArray()) {
            if (!characterToCount.containsKey(character)) {
                characterToCount.put(character, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueByUsingArray(String input) {
        if (input.length() > 256)
            return false;
        // leveraging ASCII table
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            // convert to asc value ahihi
            int val = input.charAt(i);
            // found something here
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isUniqueByUsingArray("abcdef"));
    }
}
