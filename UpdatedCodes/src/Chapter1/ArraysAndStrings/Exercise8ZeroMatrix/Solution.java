package Chapter1.ArraysAndStrings.Exercise8ZeroMatrix;

public class Solution {
    void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // nullify row
        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(matrix, i);
        }

        // nullify column
        for (int i = 0; i < column.length; i++) {
            if (column[i])
                nullifyColumn(matrix, i);
        }
    }

    private void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }


    public static void main(String[] args) {

    }
}
