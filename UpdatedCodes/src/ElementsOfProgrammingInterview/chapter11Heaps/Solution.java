package ElementsOfProgrammingInterview.chapter11Heaps;

import edu.princeton.cs.algs4.Heap;

public class Solution {
    public static void main(String[] args) {
        // heap construction and sort down
        Integer[] unsortedArr = new Integer[] {1, 2, 3, -1, -3, -4, -6};
        Heap.sort(unsortedArr);
        for (var a: unsortedArr) {
            System.out.println(a);
        }
    }
}
