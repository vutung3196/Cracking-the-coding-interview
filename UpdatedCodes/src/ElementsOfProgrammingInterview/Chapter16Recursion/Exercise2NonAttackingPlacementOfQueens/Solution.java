package ElementsOfProgrammingInterview.Chapter16Recursion.Exercise2NonAttackingPlacementOfQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Write a program which returns all distinct non-attacking placements of n queens on
    //a nxn chessboard, where n is an input to the program.
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void solveNQueens(int n, int row, ArrayList<Integer> colPlacements, List<List<Integer>> result) {
        if (row == n) {
            // All queens are legally placed
            result.add(new ArrayList<>(colPlacements));
        } else {
            for (int col = 0; col < n; col++) {
                colPlacements.add(col);
                if (isValid(colPlacements)) {
                    solveNQueens(n, row + 1, colPlacements, result);
                }
                colPlacements.remove(colPlacements.size() - 1);
            }
        }
    }

    // Test if a newly placed queen will conflict any earlier queens
    private static boolean isValid(ArrayList<Integer> colPlacements) {
        int rowID = colPlacements.size() - 1;
        for (int i = 0; i < rowID; ++i) {
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(rowID));
            if (diff == 0 || diff == rowID - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var result = nQueens(5);
        for (var listResult : result) {
            for (var element : listResult) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
