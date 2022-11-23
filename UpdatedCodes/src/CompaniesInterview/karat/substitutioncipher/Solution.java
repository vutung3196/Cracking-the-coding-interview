package CompaniesInterview.karat.substitutioncipher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        var s = "It was all a dream.";
        var key = "THEQUICKONYXGBLRASWDJMPVZF";
        System.out.println(encrypt(s, key));
    }

    public static String encrypt(String text, String key) {
        Set<Character> keySet = new HashSet<>();
        List<Character> keys = new ArrayList<>();
        for (var character : key.toCharArray()) {
            char ch = Character.toLowerCase(character);
            if (!keySet.contains(character) && ch - 'a' >= 0 && ch - 'a' < 26) {
                keySet.add(character);
                keys.add(character);
            }
        }

        var sb = new StringBuilder();
        for (var ch: text.toCharArray()) {
            boolean isUpperCase = Character.isUpperCase(ch);
            ch = Character.toLowerCase(ch);
            if (ch - 'a' >= 0 && ch - 'a' < 26 && isUpperCase) {
                int index = ch - 'a';
                sb.append(Character.toUpperCase(keys.get(index)));
            } else if (ch - 'a' >= 0 && ch - 'a' < 26 && !isUpperCase) {
                sb.append((keys.get(ch - 'a')));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

