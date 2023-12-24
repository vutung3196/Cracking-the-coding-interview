package McGillProgrammingChallenge.datastructures.doorman;

public class Solution {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter the diff: ");
        int maxDiff = scanner.nextInt();
        System.out.println("Please enter the queue: ");
        String queue = scanner.next();
        char[] line = queue.toCharArray();
        System.out.println(maximumNumberOfPeople(maxDiff, line));
    }

    public static int maximumNumberOfPeople(int diff, char[] s) {
        int m = 0;
        int w = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'M') {
                if (Math.abs(m+1 - w) > diff) {
                    if (i != s.length - 1 && s[i+1] == 'W') {
                        w++;
                        s[i+1] = 'M';
                    } else {
                        break;
                    }
                } else {
                    m++;
                }
            }
            if (s[i] == 'W') {
                if (Math.abs(m - (w+1)) > diff) {
                    if (i != s.length - 1 && s[i+1] == 'M') {
                        m++;
                        s[i+1] = 'W';
                    } else {
                        break;
                    }
                } else {
                    w++;
                }
            }
        }
        return m + w;
    }
}
