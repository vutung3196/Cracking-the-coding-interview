package Chapter1.ArraysAndStrings.Exercise7RotateMatrix;

import edu.princeton.cs.algs4.StdOut;


/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, <br>
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Solution {
    // swap index by index
    // matrix n x n
    // https://raw.githubusercontent.com/ondrej-kvasnovsky/algorithms/master/assets/rotate-image.png
    static void rotate(int[][] matrix, int n) {
        // start with outer layer
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                // save top
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }

    public static String toString(int[][] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        // print the count
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append("\n");
            for (int j = 0; j < arr[i].length; j++) {
                stringBuilder.append(arr[i][j]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int count = 0;
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        StdOut.println(toString(arr));
        rotate(arr, 3);
        StdOut.println("==================");
        StdOut.println(toString(arr));
    }
}
