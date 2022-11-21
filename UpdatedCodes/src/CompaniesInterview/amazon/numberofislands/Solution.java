package CompaniesInterview.amazon.numberofislands;

public class Solution {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int numsIsland = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numberOfRow = grid.length;
        int numberOfColumn = grid[0].length;
        for (int row = 0; row < numberOfRow; row++) {
            for (int column = 0; column < numberOfColumn; column++) {
                if (grid[row][column] == '1') {
                    numsIsland++;
                    // dfs here
                    dfs(grid, row, column);
                }
            }
        }
        return numsIsland;
    }

    /**
     * Basically just apply the BFS algorithm here
     * @param grid
     * @param row
     * @param column
     */
    private void dfs(char[][] grid, int row, int column) {
        int numberOfRow = grid.length;
        int numberOfColumn = grid[0].length;

        if (row < 0 || column < 0 || row >= numberOfRow || column >= numberOfColumn || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
