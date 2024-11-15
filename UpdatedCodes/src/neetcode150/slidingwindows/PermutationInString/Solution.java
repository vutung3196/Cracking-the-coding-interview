package neetcode150.slidingwindows.PermutationInString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    boolean flag = false;

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        // s1 and s2
        // returns true if s2 contains a permutation of s1
        // s1 = "ab"
        permute(s1, s2, 0);
        return flag;
    }

    public String swap(String s, int i0, int i1) {
        if (i0 == i1) {
            return s;
        }

        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }

    void permute(String s1, String s2, int l) {
        if (l == s1.length()) {
            if (s2.indexOf(s1) >= 0) {
                flag = true;
            }
        } else {
            for (int i = l; i < s1.length(); i++) {
                s1 = swap(s1, l, i);
                permute(s1, s2, l + 1);
                s1 = swap(s1, l, i);
            }
        }
    }

    public boolean checkInclusionHashMap(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();

        // store the frequency here!
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }

            if (matches(s1Map, s2map)) return true;
        }

        return false;
    }

    // change hashmap to an array
    public boolean matches(HashMap<Character, Integer> s1map,
                           HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusionArr(String s1, String s2) {
        // s1 and s2
        // returns true if s2 contains a permutation of s1
        if (s1.length() > s2.length()) return false;
        int[] s1arr = new int[26];
        // HashMap<Character, Integer> s1Map = new HashMap<>();
        // store the frequency here
        for (var character : s1.toCharArray()) {
            s1arr[character - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2arr = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2arr[s2.charAt(i + j) - 'a']++;
            }

            if (matches(s1arr, s2arr)) return true;
        }

        return false;
    }

    public boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i < 26; i++) {
            if (s1arr[i] != s2arr[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusionSlidingWindows(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1arr = new int[26];
        int[] s2arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1arr, s2arr))
                return true;
            s2arr[s2.charAt(i + s1.length()) - 'a']++;
            s2arr[s2.charAt(i) - 'a']--;
        }

        return matches(s1arr, s2arr);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int substringLengthLimit = s.length() - 10;
        Map<String, Integer> sequenceCounts = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= substringLengthLimit; i++) {
            String currentSubstring = s.substring(i, i + 10);
            sequenceCounts.put(currentSubstring, sequenceCounts.getOrDefault(currentSubstring, 0)  + 1);
            if (sequenceCounts.get(currentSubstring) == 2) {
                result.add(currentSubstring);
            }
        }
        return result;
    }
}
