package ElementsOfProgrammingInterview.chapter1Bitmanipulation;

public class NumberOfBitsSetToOne {

    public static void main(String[] args) {
        // Writing a program to count the number of bits that are set to 1 in an integer
        // Time complexity: O(n), where n is the number of bits in the integer word
        System.out.println(calculate(1234));
        System.out.println(calculate(1235));
        System.out.println(calculate(1236));
        System.out.println(calculate(1237));
	    // write your code here
    }

    static short calculate(int number) {
        short result = 0;
        while (number != 0) {
            result += number & 1;
            // right shift the number
            number >>>= 1;
        }
        return result;
    }
}
