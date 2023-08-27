package CompaniesInterview.google.previousOa2022;


/**
 * Refer:
 * int solve(int A, int B, int C) {
 *   int s = 1, X = 0;
 *   while (A > 0 || B > 0 || C > 0) {
 *     int a = A % 2, b = B % 2, c = C % 2;
 *     if (((a | 0) & (b | 0)) == c) {
 *       X += 0 * s;
 *     } else if (((a | 1) & (b | 1)) == c) {
 *       X += 1 * s;
 *     } else {
 *       return -1;
 *     }
 *     s *= 2;
 *     A /= 2;
 *     B /= 2;
 *     C /= 2;
 *   }
 *   return X;
 * }
 */

public class FindX {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
