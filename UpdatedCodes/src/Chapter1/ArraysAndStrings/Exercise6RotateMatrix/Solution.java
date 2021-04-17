package Chapter1.ArraysAndStrings.Exercise6RotateMatrix;

/**
 * aabcccccaaa -> a2b1c5a3
 * if the compressed one would not become smaller than the original string
 * , your method should return the original string
 */
public class Solution {
    private static String compress(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int countCompressed = countCompression(input);
        if (countCompressed >= input.length()) return input;

        int consecutiveCount = 1;
        int index1 = 0, index2 = 1;
        while (index1 < input.length() && index2 < input.length()) {
            if (input.charAt(index1) == input.charAt(index2)) {
                consecutiveCount++;
                continue;
            }
            stringBuilder.append(input.charAt(index1));
            stringBuilder.append(consecutiveCount);
            consecutiveCount = 1;
            index1++;
            index2++;
        }
        // index 2 == input.length()
        stringBuilder.append(input.charAt(index1));
        stringBuilder.append(consecutiveCount);

        if (stringBuilder.length() >= input.length()) return input;
        return stringBuilder.toString();
    }

    static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1;
                // aa...a : 100 count -> a100 (3 characters)
                compressedLength += String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        System.out.println(compress("aaaaaaaaaaaaaaaaabbbbbbbbbbbbbcaaaaaaaaaaadsdsdsdsds"));
    }
}
