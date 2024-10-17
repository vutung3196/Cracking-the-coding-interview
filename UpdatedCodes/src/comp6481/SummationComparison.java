package comp6481;

import java.util.Scanner;

public class SummationComparison {

    public static int[] getBoundarySums(int[][] matrix) {

        int n = matrix.length;
        int sums[] = new int[n+1];
        int odd_sum = 0;
        if(n%2 != 0) {
            sums[1] = matrix[n/2][n/2];
            odd_sum = matrix[n/2][n/2];
        }

        // Iterate over each layer of the matrix
        for (int layer = 0; layer < n / 2; layer++) {
            int sum = 0 ;

            // Sum the top boundary
            for (int i = layer; i <= n - layer - 1 ; i++) {
                sum += matrix[layer][i];
            }

            // Sum the bottom boundary
            for (int i = layer; i <= n - layer - 1 ; i++) {
                sum += matrix[n-layer-1][i];
            }

            // Sum the left boundary
            for (int i = layer+1; i <= n-2-layer; i++) {
                sum += matrix[i][layer];
            }

            // Sum the right boundary
            for (int i = layer+1; i <= n-2-layer; i++) {
                sum += matrix[i][n-1-layer];
            }

            // sums[n - layer * 2] = sum;   //Works for 1,3,5,7.....2,4,6
            // sums[n/2 - layer] = sum; // works for even 1,2,3,4
            if(n%2 == 0) {
                sums[n/2 - layer] = sum; // works for even 1,2,3,4
            }
            else {
                sums[n/2 - layer] = sum; // works for even 1,2,3,4
                sums[n/2 + 1] = odd_sum;
            }


        }
        for(int z=0;z<sums.length;z++) {
            System.out.print(sums[z] + " ");
        }

        return sums;
    }

    static void findSameValuesIndices(int[] array) {
        int[] values = new int[array.length];
        int[] counts = new int[array.length];
        int uniqueCount = 0;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];

            // Ignore the value 0
            if (value != 0) {
                boolean found = false;

                // Check if the value is already in the 'values' array
                for (int j = 0; j < uniqueCount; j++) {
                    if (values[j] == value) {
                        found = true;
                        counts[j]++;
                        break;
                    }
                }

                // If the value is not found, add it to the 'values' array
                if (!found) {
                    values[uniqueCount] = value;
                    counts[uniqueCount] = 1;
                    uniqueCount++;
                }
            }
        }

        // Print the indices for each value with occurrences greater than one
        boolean isFound = false;
        for (int i = 0; i < uniqueCount; i++) {
            int value = values[i];
            int count = counts[i];

            if (count > 1) {
                System.out.print("[");
                boolean isFirstIndex = true;
                int res = 0;

                // Print the indices for the current value
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == value) {
                        if (isFirstIndex) {
                            isFirstIndex = false;
                        } else {
                            System.out.print(",");
                        }
                        // if(j%2 != 0){
                        //     if(j == 1) {
                        //         System.out.print(j);
                        //     }
                        //     else {
                        //         System.out.print(j/2 + 1);
                        //     }
                        // }
                        // else {
                        System.out.print(j);
                        // }
                        res += array[j];
                    }
                }

                System.out.println("] Sum " + res/count);
                isFound = true;
                res = 0;
            }
        }
        if (!isFound) {
            System.out.println("No Match Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Matrix Size: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        // Read the matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Get the boundary sums
        int[] sums = getBoundarySums(matrix);

        findSameValuesIndices(sums);

        scanner.close();
    }
}