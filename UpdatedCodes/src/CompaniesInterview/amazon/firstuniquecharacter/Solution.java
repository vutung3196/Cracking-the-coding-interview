package CompaniesInterview.amazon.firstuniquecharacter;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        var result =  firstUniqChar("leetcode");
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        var characterToCount = new HashMap<Character, Integer>();
        var charArray = s.toCharArray();
        // check each character in the string
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            characterToCount.put(c, characterToCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (characterToCount.get(charArray[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
