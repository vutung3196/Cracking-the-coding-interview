package Comp6651.Chapter2.DevideAndConquer.mergeksortedarrays;

public class Solution {
// Java program to merge K sorted arrays of size n each.
        static final int N = 4;

        // Merge arr1[0..n1-1] and arr2[0..n2-1] into
        // arr3[0..n1+n2-1]
        static void mergeArrays(int arr1[], int arr2[], int N1,
                                int N2, int arr3[])
        {
            int i = 0, j = 0, k = 0;

            // Traverse both array
            while (i < N1 && j < N2) {
                // Check if current element of first
                // array is smaller than current element
                // of second array. If yes, store first
                // array element and increment first array
                // index. Otherwise do same with second array
                if (arr1[i] < arr2[j])
                    arr3[k++] = arr1[i++];
                else
                    arr3[k++] = arr2[j++];
            }

            // Store remaining elements of first array
            while (i < N1)
                arr3[k++] = arr1[i++];

            // Store remaining elements of second array
            while (j < N2)
                arr3[k++] = arr2[j++];
        }

        // A utility function to print array elements
        static void printArray(int arr[], int size)
        {
            for (int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");
        }

        // This function takes an array of arrays as an argument
        // and All arrays are assumed to be sorted. It merges
        // them together and prints the final sorted output.
        static void mergeKArrays(int arr[][], int i, int j,
                                 int output[])
        {
            // if one array is in range
            if (i == j) {
                for (int p = 0; p < N; p++)
                    output[p] = arr[i][p];
                return;
            }

            // if only two arrays are left them merge them
            if (j - i == 1) {
                mergeArrays(arr[i], arr[j], N, N, output);
                return;
            }

            // output arrays
            int[] out1 = new int[N * (((i + j) / 2) - i + 1)];
            int[] out2 = new int[N * (j - ((i + j) / 2))];

            // divide the array into halves
            mergeKArrays(arr, i, (i + j) / 2, out1);
            mergeKArrays(arr, (i + j) / 2 + 1, j, out2);

            // merge the output array
            mergeArrays(out1, out2, N * (((i + j) / 2) - i + 1),
                    N * (j - ((i + j) / 2)), output);
        }

        // Driver's code
        public static void main(String[] args)
        {

            // Change n at the top to change number of elements
            // in an array
            int arr[][] = { { 2, 6, 12, 34 },
                    { 1, 9, 20, 1000 },
                    { 23, 34, 90, 2000 }, {-10, -9, -8, -1}, {-1000, -100, -90, -8} };

            int K = arr.length;
            int[] output = new int[N * K];

            // Function call
            mergeKArrays(arr, 0, 4, output);

            System.out.print("Merged array is "
                    + "\n");
            printArray(output, N * K);
        }
}
