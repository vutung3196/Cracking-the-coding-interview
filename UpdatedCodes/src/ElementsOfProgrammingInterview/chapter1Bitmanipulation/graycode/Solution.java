package ElementsOfProgrammingInterview.chapter1Bitmanipulation.graycode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(1 << 3);
        var result = grayCode(2);
        for (var element : result) {
            System.out.println(element);
        }
    }


    // An n-bit gray code sequence is a sequence of 2n integers where:
    // Every integer is in the inclusive range [0, 2n - 1],
    // The first integer is 0,
    // An integer appears no more than once in the sequence,
    // The binary representation of every pair of adjacent integers differs by exactly one bit, and
    // The binary representation of the first and last integers differs by exactly one bit.
    public static List<Integer> grayCode(int n) {
        // n-bit gray code sequence is  a sequence of 2^n integers
        var result = new ArrayList<Integer>();
        // first and last exactly 1 bit
        for (int i = 0; i < Math.pow(2, n); i++) {
            var currentNumber = i ^ (i >> 1);
            result.add(currentNumber);
        }

        return result;
    }
}
