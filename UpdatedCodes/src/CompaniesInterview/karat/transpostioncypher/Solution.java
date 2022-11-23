package CompaniesInterview.karat.transpostioncypher;

public class Solution {
    public static void main(String[] args) {
        System.out.println(transpositionCypher("Hello World", 4));
    }

    public static String transpositionCypher(String s, int n) {
        int len = s.length();
        int row = len / n;
        int col = n;
        char[][] matrix = new char[row][col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = s.charAt(index++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString();
    }
}
