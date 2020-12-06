import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var s = "tactcoa";
        // System.out.println(Permutation.doesHavePalindromePermutation(s));
        // Check permutation of a palindrome
        System.out.println(isPermutationOfPalindrome(s));
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                // increment the count
                table[x]++;
                if (table[x] % 2== 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        // greater than 1 => not palindrome
        return countOdd <= 1;
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        } else  if (A <= val && val <= Z) {
            return val - A;
        }
        return -1;
    }
}

class Permutation {
    public static boolean doesHavePalindromePermutation(String s) {
        // Print all permutation
        // break all characters if we can build a palindrome => true // false
        // t, a, c, t, c, o, a
        // t a t a t 
        // string with even count => all character's count must be even
        // odd count => have exactly 1 character odd count
        var foundOdd = false;
        char[] fullText = s.toLowerCase().toCharArray();
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < fullText.length; i++) {
            if (fullText[i] == ' ') {
                continue;
            }
            if (charToCount.containsKey(fullText[i])) {
                charToCount.put(fullText[i], charToCount.get(fullText[i]) + 1);
            } else {
                charToCount.put(fullText[i], 1);
            }
        }

        var counts = charToCount.values();
        for(int currentCount : counts){
            if (currentCount % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd= true;
            }
        }
        return true;
    }
}