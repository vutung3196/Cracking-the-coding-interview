package blind75.week2.ransomnote;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // iterate all characters in ransomNote
        // check each character in magazine
        // if equals => remove
        var characterInMagazineToCount = new HashMap<Character, Integer>();
        for (char character : magazine.toCharArray()) {
           var currentCount = characterInMagazineToCount.getOrDefault(character, 0);
           characterInMagazineToCount.put(character, currentCount + 1);
        }

        for (char character : ransomNote.toCharArray()) {
            if (!characterInMagazineToCount.containsKey(character) || characterInMagazineToCount.get(character) == 0) {
                return false;
            } else {
                var currentCount = characterInMagazineToCount.get(character);
                characterInMagazineToCount.put(character, currentCount - 1);
            }
        }

        return true;
    }
}
