package com.minesweeper;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs = 0;

    // 2 dimensional arrays
    private Cell[][] cells;
    private Cell[] bombs;
    private int numExposedRemaining;
    private int numUnexposedRemaining;

    public Board(int rows, int columns, int bombs) {
        this.nRows = rows;
        this.nColumns = columns;
        this.nBombs = bombs;
    }

    private void initializeBoard() {
        cells = new Cell[nRows][nColumns];
        bombs = new Cell[nBombs];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                cells[r][c] = new Cell(r, c);
            }
        }

        for (int i = 0; i < nBombs; i++) {
            int r = i / nColumns;
            int c = (i - r * nColumns) % nColumns;
            bombs[i] = cells[r][c];
            bombs[i].setBomb(true);
        }
    }

    void shuffleBoard() {
        int nCells = nRows * nColumns;
        Random random = new Random();
        for (int index1 = 0; index1 < nCells; index1++) {
            int index2 = index1 + random.nextInt(nCells - index1);
            if (index1 != index2) {
                /* get cell for index1 */
                int row1 = index1 / nColumns;
                int column1 = (index1 - row1 * nColumns) % nColumns;
                Cell cell1 = cells[row1][column1];

                /* get cell for index2 */
                int row2 = index2 / nColumns;
                int column2 = (index2 - row2 * nColumns) % nColumns;
                Cell cell2 = cells[row2][column2];

                /* swap */
                cells[row1][column1] = cell2;
                cell2.setRow(row1);
                cell2.setColumn(column1);
                cells[row2][column2] = cell1;
                cell1.setRow(row2);
                cell1.setColumn(column2);
            }
        }
    }

    private boolean inBounds(int row, int column) {
        return row > 0 && row <= nRows && column > 0 && column <= nColumns;
    }

    /* setting the numbered cells */
    private void setNumberedCells() {
        int[][] deltas = { // Offsets of 8 surrounding cells
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };
        for(Cell bomb: bombs) {
            int row = bomb.getRow();
            int column = bomb.getColumn();
            for(int[] delta: deltas) {
                int r = row + delta[0];
                int c = column + delta[1];
                if (inBounds(r, c)) {
                    cells[r][c].incrementNumber();
                }
            }
        }
    }

    public void printBoard(boolean showUnderSide) {
        System.out.println();
        System.out.println("  ");
        for (int i = 0; i < nColumns; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < nColumns; i++) {
            System.out.println("--");
        }
        for (int r = 0; r < nRows; r++) {
            System.out.println(r + "|");
            for (int c = 0; c < nColumns; c++) {
                if (showUnderSide) {
                    System.out.println(cells[r][c].getUndersideState());
                } else {
                    System.out.println(cells[r][c].getSurfaceState());
                }
            }
            System.out.println();
        }
    }

    private boolean flipCell(Cell cell) {
        if (!cell.isExposed() && !cell.isGuess()) {
            cell.flip();
            numUnexposedRemaining--;
            return true;
        }
        return false;
    }

    public void expandBlank(Cell cell) {
        int[][] deltas = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };
        Queue<Cell> toExplore = new LinkedList<>();
        toExplore.add(cell);
        while(!toExplore.isEmpty()) {
            Cell current = toExplore.remove();
            for(int[] delta : deltas) {
                int r = current.getRow() + delta[0];
                int c = current.getColumn() + delta[1];
                if (inBounds(r, c)) {
                    Cell neighBor = cells[r][c];
                    if (flipCell(neighBor) && neighBor.isBlank()) {
                        toExplore.add(neighBor);
                    }
                }
            }
        }
    }

    public UserPlayResult playFlip(UserPlay play) {
        Cell cell = getCellAtLocation(play);
        if (cell == null) {
            return new UserPlayResult(false, Game.GameState.RUNNING);
        }

        if (play.isGuess()) {
            boolean guessResult = cell.toggleGuess();
            return new UserPlayResult(guessResult, Game.GameState.RUNNING);
        }

        boolean result = flipCell(cell);

        if (cell.isBomb()) {
            return new UserPlayResult(result, Game.GameState.LOST);
        }

        if (cell.isBlank()) {
            expandBlank(cell);
        }

        if (numUnexposedRemaining == 0) {
            return new UserPlayResult(result, Game.GameState.Won);
        }

        return new UserPlayResult(result, Game.GameState.RUNNING);
    }

    public Cell getCellAtLocation(UserPlay play) {
        int row = play.getRow();
        int col = play.getColumn();
        if (!inBounds(row, col)) {
            return null;
        }
        return cells[row][col];
    }

    public int getNumRemaining() {
        return numExposedRemaining;
    }
}
