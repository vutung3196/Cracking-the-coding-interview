package ElementsOfProgrammingInterview.chapter1Bitmanipulation.parityofaword;

public class Solution {
    public static void main(String[] args) {
        System.out.println(parity(11));
        System.out.println("======================");
        System.out.println(parity(136));
    }

    //
    public static int parity(long x) {
        short result = 0;
        while (x != 0) {
            result += (x & 1);
            x >>>= 1;
        }

        return result % 2 == 0 ? 0 : 1;
    }
}
