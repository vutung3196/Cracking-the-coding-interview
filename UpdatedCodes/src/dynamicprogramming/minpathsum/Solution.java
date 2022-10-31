package dynamicprogramming.minpathsum;

public class Solution {
    public static void main(String[] args) {
    }

    /**
     * Using 2d matrix
     * m*n time and space complexity
     * @param grid
     * @return minimum path sum
     */
    private static int minPathSum(int[][] grid) {
        // bottom up
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * Using 1 array
     * o(m*n): time complexity
     * O(n): space complexity
     * @param grid
     * @return
     */
    private static int minPathSumUsingArray(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

}
