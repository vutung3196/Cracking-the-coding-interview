package neetcode150.array.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        // check elements in a row
        for (int row = 0; row < board.length; row++) {
            var elementsInARow = new HashSet<Character>();
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] != '.') {
                    if (elementsInARow.contains(board[row][column])) {
                        return false;
                    }
                    elementsInARow.add(board[row][column]);
                }
            }
        }


        // check elements in a column
        for (int column = 0; column < board.length; column++) {
            var elementsInAColumn = new HashSet<Character>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != '.') {
                    if (elementsInAColumn.contains(board[row][column])) {
                        return false;
                    }
                    elementsInAColumn.add(board[row][column]);
                }
            }
        }

        // check in 3x3
        for (int mainRow = 0; mainRow < 3; mainRow++) {
            for (int mainColumn = 0; mainColumn < 3; mainColumn++) {
                var elementInASubBox = new HashSet<Character>();
                for (int row = mainRow * 3; row < (mainRow + 1) * 3; row++) {
                    for (int column = mainColumn * 3; column < (mainColumn + 1) *3; column++) {
                        if (board[row][column] != '.') {
                            if (elementInASubBox.contains(board[row][column]))
                                return false;
                            elementInASubBox.add(board[row][column]);
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {
        // check elements in a row
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i)) {
                        return false;
                    }
                    if (!seen.add(number + " in column " + j)) {
                        return false;
                    }
                    if (!seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
