package CompaniesInterview.drw.maximalsizeofsquare;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fillTheSquareMathematicalIdeal(8, 0));
        System.out.println(fillTheSquareMathematicalIdeal(9, 0));
        System.out.println(fillTheSquareMathematicalIdeal(0, 18));
        System.out.println(fillTheSquareMathematicalIdeal(13, 5));
    }

    //Given M units of 2 by 2 square, and N units of 1 by 1 squares. Find the maximum size of square that you can make with them.
    //Example:
    //M = 3, N = 1
    //Output: 2
    //Output: 2
    //Constraints:
    //0 <= M <= 1e9
    //0 <= N <= 1e9
    // Fill
//    public static int fillTheSquare(int m, int n) {
//        int p = 1;
//        p = Integer.parseInt(Math.floor(Math.sqrt(4*m + n)));
//        // maximum size of a square
//        for (p * p < 4*m + n) {
//            // can fill 2x2 squares and 1x1 squares to a square having
//            int a = 1;          // for 2x2
//            int b = 1;          // for 1x1
//            var x = Math.floor(p / 2);
//            if (m <= x) {
//                var currentSquare = m*m;
//                var remainingSquareFor1x1 = p*p - currentSquare;
//                if (remainingSquareFor1x1 == n) {
//                    return p;
//                }
//            }
//            p++;
//        }
//
//
//
//
//        return p;
//    }

    public static int fillTheSquareMathematicalIdeal(int m, int n) {
        int k = 0;
        var maximumNumber = (int)(Math.floor(Math.sqrt(m + 4*n)));
        for (k = maximumNumber; k >= 0; k--) {
            if (k*k <= m+ 4*n && m+ 4*n <= (k+1)*(k+1)) {
                if (k % 2 == 0) {
                    return k;
                } else {
                    if (m >= 2*k + 1) {
                        return k;
                    } else {
                        return k - 1;
                    }
                }
            }
        }
        return k;
    }


    private static boolean canFillTheSquareSizeP(int m, int n, int p) {

        return true;
    }
}
