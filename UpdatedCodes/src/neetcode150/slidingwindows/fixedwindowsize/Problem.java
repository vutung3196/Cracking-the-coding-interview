package neetcode150.slidingwindows.fixedwindowsize;

import java.util.HashMap;
import java.util.Map;

public class Problem {
    public static void main(String[] args) {
        countGoodSubString("xyzzaz");
    }

    public static int countGoodSubString(String s) {
        // no repeated characters of length 3;
        // int k = 3;
        int low = 0;
        int high = 0;
        int windowSize = 3;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (high < s.length()) {
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);
            if (high - low + 1 >= windowSize) {
                // now equal to 3
                // Step 2a: Calculate the answer based on the elements in the window
                // check if every answer is unique
                boolean found = false;
                for (var character : map.keySet()) {
                    if (map.get(character) > 1) {
                        found = true;
                    }
                }

                if (!found) {
                    result++;
                }

                // Step 2b: Remove the oldest element (at low index) from the window for the next window
                map.put(s.charAt(low), map.getOrDefault(s.charAt(low), 0) - 1);
                if (map.get(s.charAt(low)) == 0) {
                    map.remove(s.charAt(low));
                }

                low++;
            }
            high++;
        }
        return result;
    }
}
