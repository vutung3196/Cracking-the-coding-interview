package McGillProgrammingChallenge.EraseSecurely;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // read input
        // The first line of input contains a string
        // first line contains the number of flip
        // second line contains the original string
        // third line contains the string after flip
        Scanner scanner = new Scanner(System.in);
        int numberOfFlip = scanner.nextInt();
        String originalString = scanner.next();
        String flippedString = scanner.next();


       if (isSucceed(originalString, flippedString, numberOfFlip)) {
           System.out.println("Deletion succeeded");
       } else {
           System.out.println("Deletion failed");
       }
    }

    public static boolean isSucceed(String input1, String input2, int num) {
        if (input1 == null || input2 == null) return false;

        if (input1.length() != input2.length()) return false;

        if (num % 2 == 0) {
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) != input2.charAt(i)) return false;
            }
            return true;
        } else {
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) == input2.charAt(i)) return false;
            }
            return true;
        }
    }
}
