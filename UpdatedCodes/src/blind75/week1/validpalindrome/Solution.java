package blind75.week1.validpalindrome;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        var sb = new StringBuilder();
        for (var character : s.toCharArray()) {
            if (Character.isAlphabetic(character) || Character.isDigit(character)) {
                sb.append(character);
            }
        }

        var processedString = sb.toString().toLowerCase();
        var length = processedString.length();
        for (int i = 0; i < processedString.length(); i++) {
            if (processedString.charAt(i) != processedString.charAt(length - i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeV2(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            char c = s.charAt(i), d = s.charAt(j);
            if (!isAlphaNumeric(c)) {
                i++;
                continue;
            }
            if (!isAlphaNumeric(d)) {
                j--;
                continue;
            }
            if (c != d) {
                return false;
            }
            i++; j--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char character) {
        return Character.isAlphabetic(character) || Character.isDigit(character);
    }
}
