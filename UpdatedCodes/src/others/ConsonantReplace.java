package others;

public class ConsonantReplace {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(shiftConsonants(s));
    }

    private static String shiftConsonants(String input) {
        var s = input.toLowerCase().toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (!isVowels(s[i])) {
                if (s[i] == 'z') {
                    s[i] = 'b';
                } else {
                    s[i] = (char) (s[i] + 1);
                    if (isVowels(s[i])) {
                        s[i] = (char) (s[i] + 1);
                    }
                }
            }
        }

        return String.valueOf(s);
    }

    private static boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
