package blind75.week1.validanagram;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null || t != null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        var charSToCount = new HashMap<Character, Integer>();
        var charTToCount = new HashMap<Character, Integer>();
        for (var character : s.toCharArray()) {
            var currentCount = charSToCount.getOrDefault(character, 0);
            charSToCount.put(character, currentCount + 1);
        }

        for (var character : t.toCharArray()) {
            var currentCount = charTToCount.getOrDefault(character, 0);
            charTToCount.put(character, currentCount + 1);
        }

        for (var character : charSToCount.keySet()) {
            if (charSToCount.get(character) != charTToCount.get(character)) {
                return false;
            }
        }

        return true;
    }
}
