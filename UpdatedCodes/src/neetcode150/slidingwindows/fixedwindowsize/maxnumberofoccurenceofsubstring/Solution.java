package neetcode150.slidingwindows.fixedwindowsize.maxnumberofoccurenceofsubstring;

public class Solution {
    public static void main(String[] args) {
        findSequence(2030);
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        return -1;
    }

    public static void findSequence(int n) {
        // find all possible sequence of successive
        // p, p + 1,..., p +m satisfies n = p ^ 2 + (p + 1) ^ 2 + ... + (p + m) ^ 2;

        // find p where p ^ 2 + ... + (p+m) ^ 2 = n
        int currentSum = 0;
        int startingPoint = 1;
        int count = 0;
        int p = startingPoint;
        while (n > p * p) {
            currentSum += p * p;

            if (currentSum > n) {
                startingPoint++;
                p = startingPoint;
                count = 0;
                continue;
            }

            if (currentSum == n) {
                break;
            }

            count++;
            p = p + 1;
        }

        // found p
        for (int i = 0; i < count; i++) {
            System.out.println(startingPoint + i);
        }
    }
}
