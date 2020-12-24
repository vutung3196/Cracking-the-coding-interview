package com.company;

public class BinarySearch {
    int search(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            // move to the right
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                // move to the left
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
