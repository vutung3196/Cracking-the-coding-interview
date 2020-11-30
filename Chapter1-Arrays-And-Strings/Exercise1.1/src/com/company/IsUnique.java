package com.company;

import java.util.HashMap;

public class IsUnique {
    // Determine string has all unique characters and cannot use additional characters
    // Can use HashMap
    public static boolean checkUsingHashMap(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] initialText = input.toCharArray();
        for (int i = 0; i < initialText.length; i++) {
            if (map.containsKey(initialText[i])) {
                return false;
            } else {
                map.put(initialText[i], i);
            }
        }
        return true;
    }

    public static boolean isUniqueChars(String input) {
        if (input.length() > 256)
            return false;
        boolean[] charSets = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            // get the character from ASCII table
            int val = input.charAt(i);
            // found a duplicate character
            if (charSets[val]) {
                return false;
            }
            charSets[val] = true;
        }
        return true;
    }
}
