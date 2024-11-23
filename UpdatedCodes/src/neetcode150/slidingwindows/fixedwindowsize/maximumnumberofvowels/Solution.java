package neetcode150.slidingwindows.fixedwindowsize.maximumnumberofvowels;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }

    // fixed window problem
    public static int maxVowels(String s, int k) {
        int low = 0;
        int high = 0;
        int windowSize = k;
        int max = 0;

        Map<Character, Integer> wordCount = new HashMap<>();
        while (high < s.length()) {
            wordCount.put(s.charAt(high), wordCount.getOrDefault(s.charAt(high), 0) + 1);
            if (high - low + 1 >= windowSize) {
                // equal now
                // let's count
                int curr = 0;
                for (var key : wordCount.keySet()) {
                    if (key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u') {
                        curr += wordCount.get(key);
                    }
                }

                wordCount.put(s.charAt(low), wordCount.getOrDefault(s.charAt(low), 0) - 1);
                if (wordCount.get(s.charAt(low)) == 0) {
                    wordCount.remove(s.charAt(low));
                }

                max = Math.max(curr, max);
                low++;
            }
            high++;
        }
        return max;
    }
}
