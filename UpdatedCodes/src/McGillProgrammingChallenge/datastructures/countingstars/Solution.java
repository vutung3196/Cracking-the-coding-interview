package McGillProgrammingChallenge.datastructures.countingstars;

import McGillProgrammingChallenge.util.Kattio;

public class Solution {
    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in);
        int num = 1;
        while (scan.hasMoreTokens()) {
            int m = scan.getInt();
            int n = scan.getInt();
            var sky = new char[m][n];
            for (int i = 0; i < m; i++) {
                String line = scan.getWord();
                for (int j = 0; j < n; j++) {
                    sky[i][j] = line.charAt(j);
                }
            }
            int count = 0;
            boolean[][] visited = new boolean[m][n];
            for (int row = 0; row < sky.length; row++) {
                for (int column = 0; column < sky[0].length; column++) {
                    if (visited[row][column] || sky[row][column] == '#') {
                        continue;
                    }
                    count++;
                    flood(sky, visited, row, column);
                }
            }
            System.out.println("Case " + num + ": " + count);
            num++;

        }
        scan.close();
    }

    public static void flood(char[][] sky, boolean[][] visited, int r, int c) {
        int[] R = {0, 1, 0, -1};
        int[] C = {1, 0, -1, 0};
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            if (ir(sky, r + R[i], c + C[i]) && !visited[r+R[i]][c+C[i]] && sky[r+R[i]][c+C[i]] == '-') {
                flood(sky, visited, r+R[i], c+C[i]);
            }
        }
    }

    public static boolean ir(char[][] sky, int r, int c) {
        return r > -1 && c > -1 && r < sky.length & c < sky[0].length;
    }
}
