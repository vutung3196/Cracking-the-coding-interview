package CompaniesInterview.karat.FindaRectangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        board[0][1] = 0;
        board[0][2] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[0][0] = 1;
        board[1][0] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        var result = findRectangle(board);
        for (var element: result) {
            System.out.println(element);
        }
    }


     /*
     * Now the board also includes treasures, denoted by 1.
     *
     * Given a board and start and end positions for the player, write a function to return the shortest simple path of open spaces from start to end that includes all the treasures, if any exist. If multiple shortest paths exist, return any of them. A simple path is one that does not revisit any location.
     *
     * board3_1 = [
     *     [  1,  0,  0, 0, 0 ],
     *     [  0, -1, -1, 0, 0 ],
     *     [  0, -1,  0, 1, 0 ],
     *     [ -1,  0,  0, 0, 0 ],
     *     [  0,  1, -1, 0, 0 ],
     *     [  0,  0,  0, 0, 0 ],
     * ]
     *
     * board3_2 = [
     *     [  0,  1, -1 ],
     *     [  0,  0,  0 ],
     *     [  0,  0,  0 ],
     * ]
     *
     * treasure(board3_1, (5, 0), (0, 4)) -> None
     *
     * treasure(board3_1, (5, 2), (2, 0)) ->
     *   [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (2, 2), (2, 3), (1, 3), (0, 3), (0, 2), (0, 1), (0, 0), (1, 0), (2, 0)]
     *   Or
     *   [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (3, 3), (2, 3), (1, 3), (0, 3), (0, 2), (0, 1), (0, 0), (1, 0), (2, 0)]
     *
     * treasure(board3_1, (0, 0), (4, 1)) ->
     *   [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (2, 2), (3, 2), (3, 1), (4, 1)]
     *   Or
     *   [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 2), (3, 1), (4, 1)]
     *
     * treasure(board3_2, (2, 1), (1, 2)) ->
     *   [(2, 1), (2, 0), (1, 0), (0, 0), (0, 1), (1, 1), (1, 2)]
     *
     * n: width of the input board
     * m: height of the input board
     */

    /**
     * there is an image filled with 0s and 1s.
     * There is at most one rectangle in this image filled with 0s,
     * find the rectangle.
     * Output could be the coordinates of top-left and bottom-right elements of the rectangle,
     * or top-left element, width and height.
     *
     * @param board
     * @return
     */
    public static int[] findRectangle(int[][] board) {
        int[]result = new int[4];
        if (board == null || board.length == 0 || board[0].length == 0) return result;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 0) {
                    result[0] = row;
                    result[1] = column;

                    // go down
                    int height = 1;
                    int width = 1;
                    while (row + height < board.length && board[row+height][column] == 0) {
                        height++;
                    }

                    // go to the right
                    while (column + width < board[0].length && board[row][column+width] == 0) {
                        width++;
                    }
                    result[2] = row + height - 1;
                    result[3] = column + width - 1;
                    return result;
                }
            }
        }
        return result;
    }

    public static List<Shape> findMultipleRectangle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return null;
        var result = new ArrayList<Shape>();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 0) {
                    var rectangle = new Shape();
                    var currentLocation = new int[4];
                    currentLocation[0] = row;
                    currentLocation[1] = column;

                    // go down
                    int height = 1;
                    int width = 1;
                    while (row + height < board.length && board[row+height][column] == 0) {
                        height++;
                    }

                    // go to the right
                    while (column + width < board[0].length && board[row][column+width] == 0) {
                        width++;
                    }
                    currentLocation[2] = row + height - 1;
                    currentLocation[3] = column + width - 1;
                    rectangle.location = currentLocation;
                    result.add(rectangle);
                }
            }
        }

        return result;
    }

    public static List<Shape2> findAllShapes(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return null;
        var result = new ArrayList<Shape2>();

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 0) {
                    var shape = new Shape2();
                    findingShape(board, row, column, shape);
                    result.add(shape);
                }
            }
        }
        return result;
    }

    public static void findingShape(int[][] board, int row, int column, Shape2 shape) {
        if (row < 0 || row >= board.length || row < 0 || row >= board.length) return;
        shape.location.add(row);
        shape.location.add(column);
        findingShape(board, row + 1, column, shape);
        findingShape(board, row-1, column, shape);
        findingShape(board, row, column+1, shape);
        findingShape(board, row, column-1, shape);
    }

    public static class Shape2 {
        public Shape2() {
          this.location = new ArrayList<>();
        }

        public List<Integer> location;
    }

    public static class Shape {
        public Shape() {
        }

        public int[] location;
    }
}
