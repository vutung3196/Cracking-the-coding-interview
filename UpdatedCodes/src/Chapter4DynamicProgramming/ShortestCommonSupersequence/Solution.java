package Chapter4DynamicProgramming.ShortestCommonSupersequence;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        var s = "064819848398";
        var arr = new String[]{"088", "364", "07"};
       var result = (minSubstringPermutation(s, arr));
        for (var i : result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> arrayReduction(int[] arr) {
        Arrays.sort(arr); // sort in decreasing order

        HashSet<Integer> used = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; ) {
            int k = 0;
            while (i + k < arr.length && !used.contains(arr[i + k])) {
                k++;
            }
            if (k == 0) {
                break; // no unused integers left in arr
            }
            int[] subarray = Arrays.copyOfRange(arr, i, i + k);
            int mex = getMex(subarray, used);
            result.add(mex);
            for (int j = i; j < i + k; j++) {
                used.add(arr[j]);
            }
            i += k;
        }

        return result;
    }

    private static int getMex(int[] arr, HashSet<Integer> used) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!used.contains(arr[i])) {
                set.add(arr[i]);
            }
        }
        for (int i = 0; i <= set.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // should never happen
    }


    public static int[] minSubstringPermutation(String s, String[] arr) {
        int[] result = new int[arr.length];
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, 0);
        }
        for (int i = 0; i < arr.length; i++) {
            HashMap<Character, Integer> freq_t = new HashMap<>();
            for (char c : arr[i].toCharArray()) {
                freq_t.put(c, freq_t.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                freq.put(c, freq.get(c) + 1);
                if (freq_t.containsKey(c) && freq.get(c) <= freq_t.get(c)) {
                    count++;
                }
                while (count == arr[i].length()) {
                    minLen = Math.min(minLen, right - left + 1);
                    char d = s.charAt(left);
                    freq.put(d, freq.get(d) - 1);
                    if (freq_t.containsKey(d) && freq.get(d) < freq_t.get(d)) {
                        count--;
                    }
                    left++;
                }
                right++;
            }
            if (minLen == Integer.MAX_VALUE) {
                result[i] = -1;
            } else {
                result[i] = minLen;
            }
        }
        return result;
    }

    public static int solve(String s1, String s2) {
        int result = 0;
        if (s1 == s2) {
            return s1.length();
        }

        // find the length of LCS of s1 and s2
        int[][] D = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length() ; i++) {
            D[i][0] = 0;
        }

        for (int i = 0; i < s2.length(); i++) {
            D[0][i] = 0;
        }

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    D[i][j] = Math.max(D[i][j], 1 + D[i-1][j-1]);
                }
            }
        }

        result = s1.length() + s2.length() - D[s1.length()][s2.length()];
        return result;
    }
}
