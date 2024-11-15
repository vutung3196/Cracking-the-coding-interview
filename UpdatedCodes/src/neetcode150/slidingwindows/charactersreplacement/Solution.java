package neetcode150.slidingwindows.charactersreplacement;


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


}
