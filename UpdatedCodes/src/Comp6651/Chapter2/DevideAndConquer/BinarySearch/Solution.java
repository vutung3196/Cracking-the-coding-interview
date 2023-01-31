package Comp6651.Chapter2.DevideAndConquer.BinarySearch;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 4, 5};
        System.out.println(binarySearch(A, 3));
    }

    private static int binarySearch(int[] A, int v) {
        int high = A.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = ((high + low) / 2);
            if (v > A[mid]) {
                low = mid + 1;
            } else if (v < A[mid]) {
                high = mid - 1;
            } else if () {
                return mid;
            }
        }
        return -1;
    }
}
