package neetcode150.graph;

public class NumberOfIsland {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int numsIsland = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    numsIsland++;
                    dfs(grid, row, column);
                }
            }
        }

        return numsIsland;
    }

    static void dfs(char[][] grid, int row, int column) {
        int numberOfRows = grid.length;;
        int numberOfColumns = grid[0].length;

        if (row < 0 || column < 0 || row >= numberOfRows
            || column >= numberOfColumns || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';
        dfs(grid, row, column+1);
        dfs(grid, row, column-1);
        dfs(grid, row-1, column);
        dfs(grid, row+1, column);
    }
}
