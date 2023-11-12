package McGillProgrammingChallenge.coldputerscience;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        The input is composed of two lines. The first line contains a single positive integer
//        that specifies the number of temperatures collected by the University of Chicago Weather Service. The second line contains
//        temperatures, each separated by a single space. Each temperature is represented by an integer
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        // test cases are like 1 2 3 4 5
        // in a single line
        int[] testCases = new int[numberOfTestCases];
        for (int i = 0; i < numberOfTestCases; i++) {
            testCases[i] = scanner.nextInt();
        }

        coldputerScience(testCases);
    }

    public static void coldputerScience(int[] arr) {
        int count = 0;
        for (var num : arr) {
            if (num < 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
