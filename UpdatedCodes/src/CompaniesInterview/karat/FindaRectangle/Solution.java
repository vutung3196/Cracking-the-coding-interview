package CompaniesInterview.karat.FindaRectangle;

public class Solution {
    public static void main(String[] args) {

    }

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
    public int[] findRectangle(int[][] board) {
        int[]result = new int[4];
        if (board == null || board.length == 0 || board[0].length == 0) return result;
        int foundBottom = 0;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 0) {
                    result[0] = row;
                    result[1] = column;
                }

//                // go down
//                int height = 1;
//                int width = 1;
//                while (row + height < board.length && board[row+height][column] == 0) {
//                    height++;
//                }
//
//                // go to the right
//                while (column + width < board[0].length && board[row][column+width] == 0) {
//                    width++;
//                }
                for (int foundRow = row; foundRow < board.length; foundRow++) {
                    if (board[foundRow][column] == 1) {
                        foundBottom = foundRow - 1;
                        result[2] = foundBottom;
                        break;
                    }

                }

                // go to the right
                for (int foundColumn = column; foundColumn < board[0].length; foundColumn++) {
                    if (board[foundColumn][foundBottom] == 1) {
                        result[3] = foundColumn - 1;
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
