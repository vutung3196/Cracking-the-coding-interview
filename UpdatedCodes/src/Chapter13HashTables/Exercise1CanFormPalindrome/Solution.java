package Chapter13HashTables.Exercise1CanFormPalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean canFormPalindrome(String s) {
        Map<Character, Integer> characterToFrequencies = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!characterToFrequencies.containsKey(c)) {
                characterToFrequencies.put(c, 1);
            } else {
                characterToFrequencies.put(c, characterToFrequencies.get(c) + 1);
            }
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> p : characterToFrequencies.entrySet()) {
            if (p.getValue() % 2 != 0) {
                if (oddCount == 1) return false;
                oddCount++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("level"));
        System.out.println(canFormPalindrome("rotator"));
        System.out.println(canFormPalindrome("foobaraboof"));
    }
}
