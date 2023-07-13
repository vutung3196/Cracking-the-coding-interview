package ElementsOfProgrammingInterview.chapter1Bitmanipulation.basics;

public class Solution {
    public static void main(String[] args) {
//        printBinaryTree(123);
        checkIfIthBitSetOrNot(123, 1);
    }

    // printing the binary representation of any number
    static void printBinaryTree(int num) {
        for (int i = 10; i >= 0; i--) {
            var currentBit = (num >> i) & 1;
            System.out.println(currentBit);
        }
    }

    // check if the ith bit is set (equal to 1) or not
    static void checkIfIthBitSetOrNot(int num, int k) {
        if ((num & (1 << k)) != 0) {
            System.out.println("SET");
        } else {
            System.out.println("NOT SET");
        }
    }

    // check if a given number is a power of 2
    // if the number is neither 0 nor a power of 2 => will have 1 in more than 1 place
    static boolean isPowerOfTwo(int number) {
        return (number != 0 && ! ((number & (number - 1)) == 0));
    }

    // counting the number of set bits
    static int countSetBits(int number) {
        int count = 0;
        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }

            // Right shift the number by 1 to move to the next bit
            number >>= 1;
        }

        return count;
    }

}
