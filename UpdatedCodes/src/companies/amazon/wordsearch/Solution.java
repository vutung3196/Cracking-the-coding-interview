package companies.amazon.wordsearch;

public class Solution {
    private static class Board {
        private char[][] board;
        private int ROWS;
        private int COLS;

    }
    // https://leetcode.com/problems/word-search/
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }


    /// USING Backtracking approach for this problem
    public static boolean exist(char[][] board, String word) {
        // trying to use the Brute force approach here!
        var currentBoard = new Board();
        currentBoard.board = board;
        currentBoard.ROWS = board.length;
        currentBoard.COLS = board[0].length;

        for (int row = 0; row < currentBoard.ROWS; row++) {
            for (int collumn = 0; collumn < currentBoard.COLS; collumn++) {
                if (backTrack(row, collumn, word, 0, currentBoard)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * At the beginning, check if we reach the bottom case of the recursion, where the word to be matched is empty
     * or we have already found the match for each prefix of the word
     * Check if the current state is invalid, means either the position if out of the boundary of the board, or the letter of
     * the current cell does not match with the first letter of the word
     * Step 3: if the current step is valid, we then start the exploration of backtracking with the strategy of DFS.
     * Mark the cell as visited, then we will travel up, right, down and left
     * Step 4: Return the cell back to the original state
     * @param row
     * @param col
     * @param word
     * @param indexOfWord
     * @return
     */
    private static boolean backTrack(int row, int col, String word, int indexOfWord, Board board) {
        if (indexOfWord == word.length()) {
            return true;
        }

        if (row < 0 || row == board.ROWS || col < 0 || col == board.COLS || board.board[row][col] != word.charAt(indexOfWord)) {
            return false;
        }

        boolean found = false;

        // mark the current cell as visited
        board.board[row][col] = '#';

        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};

        for (int direction = 0; direction < 4; direction++) {
            found = backTrack(row + rowOffset[direction], col + colOffset[direction], word, indexOfWord + 1, board);
            if (found) {
                break;
            }
        }

        // return the cell back to the original state
        board.board[row][col] = word.charAt(indexOfWord);

        return found;
    }
}
