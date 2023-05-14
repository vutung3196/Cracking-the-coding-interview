package blind75.week2.longestpalindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return 1;
        }

        Set<Character> characterSet = new HashSet<Character>();
        for (var character : s.toCharArray()) {
            if (characterSet.contains(character)) {
                characterSet.remove(character);
            } else {
                characterSet.add(character);
            }
        }

        if (characterSet.size() <= 1) return s.length();
        return s.length() - characterSet.size() + 1;
    }
}
