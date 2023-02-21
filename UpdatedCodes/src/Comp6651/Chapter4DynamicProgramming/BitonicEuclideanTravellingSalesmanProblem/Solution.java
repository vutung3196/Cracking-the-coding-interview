package Comp6651.Chapter4DynamicProgramming.BitonicEuclideanTravellingSalesmanProblem;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {

    }

    private static class Coordinates {
        public int x;
        public int y;
    }

    public static double calculate(ArrayList<Coordinates> inputs) {
        // sort the inputs by x increasing
        inputs.sort(Comparator.comparingInt(a -> a.x));
        var b = new double[inputs.size()][inputs.size() - 1];
        var r = new int[inputs.size() - 2][inputs.size() - 2];
        b[0][1] = len(0, 1, inputs);
        int k, j;
        for (j = 2; j < inputs.size(); j++) {
            for (k = 0; k < j-1; k++) {
                b[k][j] = b[k][j - 1] + len(j - 1, j, inputs);
                r[k][j] = j - 1;
            }
            b[j-1][k] =Double.MAX_VALUE;
            for (k = 0; k < j - 1; k++) {
                var t = b[k][j - 1] + len(k, j, inputs);
                if (t < b[j - 1][j]) {
                    b[j - 1][j] = t;
                    r[j - 1][j] = k;
                }
            }
        }
        b[inputs.size()-1][inputs.size()-1] = b[inputs.size()-2][inputs.size()-1] +
                len(inputs.size()-2, inputs.size()-1, inputs);
        return b[inputs.size() - 2][inputs.size() - 1];
    }

    // Calculate the distance between two points having index i and j
    public static double len(int i, int j, ArrayList<Coordinates> inputs) {
        return (float) Math.sqrt(Math.pow(inputs.get(i).x - inputs.get(j).x, 2)
                + Math.pow(inputs.get(i).y - inputs.get(j).y, 2));
    }
}
