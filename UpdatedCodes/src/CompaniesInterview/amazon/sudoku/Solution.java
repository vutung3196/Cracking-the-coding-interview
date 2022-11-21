package CompaniesInterview.amazon.sudoku;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '5', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            // initialize the hashset here
            var elementsInARow = new HashSet<Character>();
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    if (elementsInARow.contains(board[row][col])) {
                        return false;
                    } else {
                        elementsInARow.add(board[row][col]);
                    }
                }
            }
        }

        // check the columns
        for (int column = 0; column < board[0].length; column++) {
            var elementsInAColumn = new HashSet<Character>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != '.') {
                    if (elementsInAColumn.contains(board[row][column])) {
                        return false;
                    } else {
                        elementsInAColumn.add(board[row][column]);
                    }
                }
            }
        }

        // check the 3x3 sub-boxes
        for (int mainRow = 0; mainRow < 3; mainRow++) {
            for (int mainColumn = 0; mainColumn < 3; mainColumn++) {
                var elementsInASubBox = new HashSet<Character>();
                for (int row = mainRow * 3; row < (mainRow + 1) * 3; row++) {
                    for (int col = mainColumn * 3; col < (mainColumn + 1) * 3; col++) {
                        if (board[row][col] != '.') {
                            if (elementsInASubBox.contains(board[row][col])) {
                                return false;
                            } else {
                                elementsInASubBox.add(board[row][col]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
