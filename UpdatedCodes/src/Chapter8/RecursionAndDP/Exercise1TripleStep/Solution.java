package Chapter8.RecursionAndDP.Exercise1TripleStep;

public class Solution {
    static int countStep(int n) {
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else return countStep(n - 1) + countStep(n - 2) + countStep(n - 3);
    }

    // for gcd
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int getInvolved(int a, int b) {
        return 0;
    }

    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
    }
}
