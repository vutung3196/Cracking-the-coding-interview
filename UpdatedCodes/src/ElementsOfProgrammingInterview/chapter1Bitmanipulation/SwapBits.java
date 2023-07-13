package ElementsOfProgrammingInterview.chapter1Bitmanipulation;

public class SwapBits {
    public static void main(String[] args) {
        // 73 => 0 1 0 0 1 0 0 1
        // 11 => 0 0 0 0 1 0 1 1
        System.out.println(swapBits(73, 1, 6));
    }

    static long swapBits(long input, int i, int j) {
        // perform the flip XOR
        // if they differ
        if (((input >>> i) & 1) != ((input >>> j) & 1)) {
            // i-th and j-th bits differ
            long bitmask = (1L << i) | (1L << j);
            input ^= bitmask;
        }
        return input;
    }
}
