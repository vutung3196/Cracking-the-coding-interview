package McGillProgrammingChallenge.quickbrownfox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        checkPangram("ZYXW, vu TSR Ponm lkj ihgfd CBA.");
    }

    public static boolean checkPangram(String input) {
        boolean[] mark = new boolean[26];
        Set<Character> missingCharacters = new HashSet<>();
        input = input.toLowerCase();
        var indexToChar = new HashMap<Integer, Character>();
        indexToChar.put(0, 'a');
        indexToChar.put(1, 'b');
        indexToChar.put(2, 'c');
        indexToChar.put(3, 'd');
        indexToChar.put(4, 'e');
        indexToChar.put(5, 'f');
        indexToChar.put(6, 'g');
        indexToChar.put(7, 'h');
        indexToChar.put(8, 'i');
        indexToChar.put(9, 'j');
        indexToChar.put(10, 'k');
        indexToChar.put(11, 'l');
        indexToChar.put(12, 'm');
        indexToChar.put(13, 'n');
        indexToChar.put(14, 'o');
        indexToChar.put(15, 'p');
        indexToChar.put(16, 'q');
        indexToChar.put(17, 'r');
        indexToChar.put(18, 's');
        indexToChar.put(19, 't');
        indexToChar.put(20, 'u');
        indexToChar.put(21, 'v');
        indexToChar.put(22, 'w');
        indexToChar.put(23, 'x');
        indexToChar.put(24, 'y');
        indexToChar.put(25, 'z');


        int index = 0;
        for (int i = 0; i < 26; i++) {
            if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                index = input.charAt(i) - 'A';
            } else if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                index = input.charAt(i) - 'a';
            } else {
                continue;
            }

            mark[index] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!mark[i]) {
                missingCharacters.add(indexToChar.get(i));
            }
        }

        if (missingCharacters.isEmpty()) {
            System.out.println("pangram");
            return true;
        } else {
            // put all the missing characters in a string
            var missingCharactersString = new StringBuilder();
            for (var character : missingCharacters) {
                missingCharactersString.append(character);
            }
            System.out.println("missing " + missingCharactersString.toString());
            return false;
        }
    }
}
