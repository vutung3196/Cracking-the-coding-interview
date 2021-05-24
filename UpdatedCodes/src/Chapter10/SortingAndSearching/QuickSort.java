package Chapter10.SortingAndSearching;

/**
 * Time complexity: average o(n^2) <br>
 * Best case: O(n*log(n))
 */
public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        int index = partition(arr, low, high);
        // sort low half
        if (low < index - 1) sort(arr, low, index - 1);
        if (index < high) sort(arr, index, high);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
            printArray(arr);
            System.out.println();
        }
        return left;
    }

    private static void printArray(int[] arr) {
        for(int a : arr)
            System.out.print(a + " ");
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;
        arr[3] = 4;
        arr[4] = 5;
        sort(arr);
    }
}
