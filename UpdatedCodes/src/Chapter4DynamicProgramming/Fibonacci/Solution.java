package Chapter4DynamicProgramming.Fibonacci;

public class Solution {
    public static void main(String[] args) {
        System.out.println(iterativeFib(10));
    }

    public static int iterativeFib(int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = -1;
        }

        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }
}
