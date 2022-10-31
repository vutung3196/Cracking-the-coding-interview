package dynamicprogramming.uniquepaths;

import java.util.Arrays;

public class Solution {
    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
     * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
     * The robot can only move either down or right at any point in time.
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     * @param args
     */
    public static void main(String[] args) {

    }


    public int uniquePathsRecursive(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
    }

    public int uniquePaths(int m, int n) {
        // initiate 2D array for the number of paths
        int[][] d = new int[m][n];
        // set all the value to 1 please!
        for (var arr: d) {
            Arrays.fill(arr, 1);
        }

        for (int column = 1; column < m; ++column) {
            for (int row = 1; row < n; row++) {
                d[row][row] = d[row - 1][row] + d[row][row - 1];
            }
        }
        return d[m-1][n-1];
    }
}
