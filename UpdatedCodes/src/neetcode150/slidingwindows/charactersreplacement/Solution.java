package neetcode150.slidingwindows.charactersreplacement;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    
    public int characterReplacement(String s, int k) {
        // string s and an integer k
        int left = 0;
        int[] charCount = new int[26];
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add a new character to window
            charCount[s.charAt(right) - 'A']++;

            // Update the max frequency in current window
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            // if number of replacement needed greater than k => shrink the window
            if (right - left + 1 - maxCount > k) {
                // remove left most character from the window
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int characterReplacementRedo(String s, int k) {
        // finding the replacement in between k
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(right)));

            // shrink the windows since we don't have enough characters
            if (right - left + 1 > maxCount) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) -1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;

        }
        return maxLength;
    }
}
