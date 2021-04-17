package Chapter1.ArraysAndStrings.Exercise3URLify;

/**
* input: "Mr John Smith    ",  13
* output: "Mr%20John%20Smith"
*/
public class Solution {
    // should use O(1) space
    private static char[] replaceSpace(char[] input, int length) {
        int newLength, count = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') count++;
        }

        newLength = count * 2 + length;

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[newLength - 1] = '0';
                input[newLength - 2] = '2';
                input[newLength - 3] = '%';
                newLength -= 3;
            } else {
                input[newLength - 1] = input[i];
                newLength -= 1;
            }
        }
        return input;
    }


    public static void main(String[] args) {
        var a = "Mr John Smith            ";
        var b = replaceSpace(a.toCharArray(), 13);
        var result = new String(b);
        System.out.println(result);
    }
}
