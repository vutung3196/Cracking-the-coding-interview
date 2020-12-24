package com.company;

public class RotatedSearch {
    public static void main(String[] args) {
        int[] arr = new int[] {15, 16, 19, 20, 25, 1, 3 ,4 ,5, 7, 10, 14};
        System.out.println(searchUsingWhileLoop(arr, 16));
        // expect 8?
    }

    // using while loop
    static int searchUsingWhileLoop(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid + 1;
                } else {
                    left = mid - 1;
                }
            } else if (arr[left] > arr[mid]) {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // recursion
    static int searchBasedOnBinary(int arr[], int x, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (right < left) {
            return -1;
        }

        // left vs right, left is ordered normally
        if (arr[left] < arr[mid]) {
            if (x >= arr[left] && x < arr[mid]) {
                return searchBasedOnBinary(arr, x, left, mid - 1);
            } else {
                return searchBasedOnBinary(arr, x, mid + 1, right);
            }
        }
        else if (arr[left] > arr[mid]) {
            if (x > arr[mid] && x <= arr[right]) {
                // Search right
                return searchBasedOnBinary(arr, x, mid + 1, right);
            } else {
                // Search left
                return searchBasedOnBinary(arr, x, left, mid - 1);
            }
        }
        else if (arr[left] == arr[mid]) {
            if (arr[mid] != arr[right]) {
                return searchBasedOnBinary(arr, x, mid + 1, right);
            } else {
                int result = searchBasedOnBinary(arr, x, left, mid - 1);
                if (result == -1) {
                    return searchBasedOnBinary(arr, x, mid + 1, right);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
