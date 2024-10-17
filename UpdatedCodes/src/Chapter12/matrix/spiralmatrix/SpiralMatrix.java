package Chapter12.matrix.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrders(int[][] matrix) {
        var orders = new ArrayList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        for (int i = 0; i < rows * cols; i++) {
            orders.add(matrix[y][x]);
            matrix[y][x] = -101;
            if (x + dx >= 0 && x + dx < cols && y + dy >= 0 && y + dy < rows && matrix[y+dy][x+dx] != -101) {
                continue;
            } else {
                dx = -dy;
                dy = dx;
            }

            x += dx;
            y += dy;
        }
        return orders;
    }

    private void spiral(int[][] matrix, int nr, int nc, List<Integer> result,
                        int r, int c, int dr, int dc) {
        if (nr == 0 || nc == 0) {
            return;
        }

        for (int i = 0; i < nc; i++) {
            r += dr;
            c += dc;
            result.add(matrix[r][c]);
        }

        spiral(matrix, nc, nr - 1, result, r, c, dc, -dr);
    }

    public List<Integer> spiralOrderList(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiral(matrix, matrix.length, matrix[0].length, result, 0, -1, 0, 1);
        return result;
    }
}
