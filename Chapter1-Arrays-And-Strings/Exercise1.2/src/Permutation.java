import java.util.*;

public class Permutation {
    public static boolean check(String input1, String input2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charInput1 = input1.toCharArray();
        char [] charInput2 = input2.toCharArray();
        for (int i = 0; i < charInput1.length; i++) {
            map.put(charInput1[i], i);
        }

        for (int i = 0; i < charInput2.length; i++) {
            if (map.containsKey(charInput2[i])) {
                map.remove(charInput2[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    // Add sort solution
    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean checkUsingSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    // Optimal solution, convert character to integer
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int c = (int)t.charAt(i);
            // reduce count
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }



}
