package neetcode150.slidingwindows.FixedWindowsExample;

public class FixedWindows {
    public static void main(String[] args) {

    }

    // Template
    //    fixed_window()
    //    {
    //        int low = 0, high = 0, windowsize = k;
    //        while (i < sizeofarray)
    //        {
    //            // Step 1: Create a window that is one element smaller than the desired window size
    //            if (high - low + 1 < windowsize)
    //            {
    //                // Generate the window by increasing the high index
    //                high++;
    //            }
    //            // Step 2: Process the window
    //            else
    //            {
    //                // Window size is now equal to the desired window size
    //                // Step 2a: Calculate the answer based on the elements in the window
    //                // Step 2b: Remove the oldest element (at low index) from the window for the next window
    //
    //                // Proceed to the next window by incrementing the low and high indices
    //            }
    //        }
    //    }

    //    Q->Given an array arr[] and an integer K, the task is to calculate the sum of
    //    all subarrays of size K.
    static int sumSubArrays(int[] arr, int k) {
        int low = 0;
        int high = 0;
        int sum = 0;
        int n = arr.length;

        while (high < n) {
            if (high - low + 1 < k) {
                sum += arr[high];
                high++;
            } else {
                sum += arr[high];
                System.out.println(sum);
                sum -= arr[high];
                low++;
                high++;
            }
        }
        return sum;
    }

    // 2 variable windows


}
