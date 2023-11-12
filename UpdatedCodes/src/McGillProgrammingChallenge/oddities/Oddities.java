package McGillProgrammingChallenge.oddities;

import java.util.Scanner;

public class Oddities {
    public static void main(String[] args) {
        // Input
        // Input begins with an integer
        // on a line by itself, indicating the number of test cases that follow. Each of the following
        // lines contain a test case consisting of a single integer
        //.
        // read input from stdin
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int[] testCases = new int[numberOfTestCases];
        for (int i = 0; i < numberOfTestCases; i++) {
            testCases[i] = scanner.nextInt();
        }

        oddityDetection(testCases);
    }

    public static void oddityDetection(int[] arr) {
        for (var num : arr) {
            if (num % 2 != 0) {
                System.out.println(num + " is odd");
            } else {
                System.out.println(num + " is even");
            }
        }
    }
}
