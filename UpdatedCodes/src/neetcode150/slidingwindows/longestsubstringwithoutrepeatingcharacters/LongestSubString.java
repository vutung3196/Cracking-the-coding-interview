package neetcode150.slidingwindows.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        var obj = new LongestSubString();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }


    //    Input: s = "abcabcbb"
    //    Output: 3
    //    Explanation: The answer is "abc", with the length of 3.
    //    Let me explain how this solution works:
    //    We use a sliding window approach with two pointers:
    //    left: start of current substring
    //    right: end of current substring
    //    We use a HashMap to store:
    //    Key: character
    //    Value: most recent position of that character
    //    For each character:
    //    If we find a repeating character, we move left pointer to position after its last occurrence
    //    We update the character's position in map
    //    We calculate current window size and update maxLength if needed
    //    Let's walk through example "abcabcbb":
    public int lengthOfLongestSubstring(String s) {
        // given a string s, find the length
        // of the longest substring without repeating characters
        int left = 0;
        int result = 0;

        // character and position of the last left index
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int lengthOfLongestSubstringTemplate(String s) {
        int start = 0, end = 0, result = 0;
        // current character and their frequency in s
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            int windowSize = end - start + 1;
            // checking whether this map is unique or not
            if (map.size() == windowSize) {
                result = Math.max(result, windowSize);
                end++;
            } else {
                while (map.size() < windowSize) {
                    map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                    start++;
                    windowSize = end - start + 1;
                }
                if (map.size() == windowSize) {
                    result = Math.max(result, windowSize);
                }

                end++;
            }
        }

        return result;
    }
}
