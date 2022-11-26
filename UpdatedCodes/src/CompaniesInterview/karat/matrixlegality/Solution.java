package CompaniesInterview.karat.matrixlegality;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * Given an N*N matrix, determine whether it is a valid matrix.
     * The definition of a valid matrix is that the
     * numbers in each row or column must be exactly 1 to N. Output a bool.
     */
    static boolean isValidMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
//        const n = matrix.length;
//        for (let i = 0; i < n; i++) {
//            const rowSet = new Set();
//            const colSet = new Set();
//            let rowMin = Number.POSITIVE_INFINITY, rowMax = Number.NEGATIVE_INFINITY;
//            let colMin = rowMin, colMax = rowMax;
//            for (let j = 0; j < n; j++) {
//                if (!rowSet.has(matrix[i][j])) {
//                    rowSet.add(matrix[i][j]);
//                    rowMin = Math.min(rowMin, matrix[i][j]);
//                    rowMax = Math.max(rowMax, matrix[i][j]);
//                } else {
//                    return false;
//                }
//                if (!colSet.has(matrix[j][i])) {
//                    colSet.add(matrix[j][i]);
//                    colMin = Math.min(colMin, matrix[j][i]);
//                    colMax = Math.max(colMax, matrix[j][i]);
//                } else {
//                    return false;
//                }
//            }
//            if (rowMin !== 1 || colMin !== 1 || rowMax !== n || colMax !== n) {
//                return false;
//            }
//        }
        return true;

    }
}
