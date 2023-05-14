package blind75.week2.longestpalindrome;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        var characterToCount = new HashMap<Character, Integer>();
        for (var character : s.toCharArray()) {
            var currentCount = characterToCount.getOrDefault(character, 0);
            characterToCount.put(character, currentCount + 1);
        }

        var result = 0;
        var oddCounts = 0;
        for (var character : characterToCount.keySet()) {
            var currentCount = characterToCount.get(character);
            if (currentCount % 2 == 0) {
                result += currentCount;
            } else {
                oddCounts += currentCount;
            }
        }

        // not complete
        return result + oddCounts;
    }
}
