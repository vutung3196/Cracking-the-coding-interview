package blind75.graph.pacificatlanticisland;

import java.util.*;

public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] landHeights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> commonCells = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return commonCells;
        }

        // check every cell - iterate through every cell and at each one, start a traversal that follows
        // find every cell that manages to reach both ocean
        // start traversing from the ocean to find the cell
        // check for the higher height instead of the lower ones
        var numRows = heights.length;
        var numColumns = heights[0].length;
        landHeights = heights;
        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();

        // pacific ocean
        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[] {i, 0});
            atlanticQueue.offer(new int[] {i, numColumns-1});
        }

        for (int i = 0; i < numColumns; i++) {
            pacificQueue.offer(new int[] {0, i});
            atlanticQueue.offer(new int[] {numRows-1, i});
        }

        boolean[][] pacificReachable = bfs(pacificQueue, numRows, numColumns);
        boolean[][] atlanticReachable = bfs(atlanticQueue, numRows, numColumns);

        // find the intersection here and add to the result
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                if (pacificReachable[row][column] && atlanticReachable[row][column]) {
                    commonCells.add(List.of(row, column));
                }
            }
        }
        return commonCells;
    }

    private boolean[][] bfs(Queue<int[]> queue, int numRows, int numColumns) {
        var reachableNodes = new boolean[numRows][numColumns];
        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            reachableNodes[currentCell[0]][currentCell[1]] = true;

            for (int[] direction : DIRECTIONS) {
                var newRow = currentCell[0] + direction[0];
                var newColumn = currentCell[1] + direction[1];

                if (newRow >= numRows || newRow < 0 || newColumn >= numColumns || newColumn < 0) {
                    continue;
                }

                if (reachableNodes[newRow][newColumn]) {
                    continue;
                }

                if (landHeights[newRow][newColumn] < landHeights[currentCell[0]][currentCell[1]]) {
                    continue;
                };

                queue.offer(new int[] {newRow, newColumn});
            }
        }
        return reachableNodes;
    }
}