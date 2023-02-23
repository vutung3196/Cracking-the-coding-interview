package Comp6651.Chapter4DynamicProgramming.TravellingSalesmanProblem;

public class Solution {
    public static void main(String[] args) {

    }

;    public static int solve(int[][] distances) {
        int n = distances.length;
        int[][] D = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                D[i][j] = -1;
            }
        }
        return solve(distances, 0, 1, D);
    }

    public static int solve(int[][] distances, int current, int visited, int[][] D) {
        if (visited == (1 << distances.length) - 1) {
            return distances[current][0];
        }
        if (D[current][visited] != -1) {
            return D[current][visited];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if ((visited & (1 << i)) == 0) {
                int newDistance = distances[current][i] + solve(distances, i, visited | (1 << i), D);
                if (newDistance < min) {
                    min = newDistance;
                }
            }
        }
        D[current][visited] = min;
        return min;
    }
}
