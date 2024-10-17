package Chapter12.matrix.rotateimage;

public class RotateImage {
    public static void main(String[] args) {
        var input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        var rotateImage = new RotateImage();
        rotateImage.rotate(input);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // reverse matrix first
        for (int first = 0, last = rows - 1; first < last; first++, last--) {
            int[] tmp = matrix[first];
            matrix[first] = matrix[last];
            matrix[last] = tmp;
        }

        // swap the symmetry
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
