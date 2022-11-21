package CompaniesInterview.amazon.greynessofcell;

import java.util.List;

import static java.util.Collections.max;

public class Solution {
    public static void main(String[] args) {
        // it works to calculate the diff
        int a = '1' - '0';
        System.out.println(a);
    }

    private static int solution(List<String> grid) {
        int n = grid.size();
        int m = grid.get(0).length();
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                row[i] += grid.get(i).charAt(j) - '0';
                col[j] += grid.get(i).charAt(j) - '0';
            }
        }

        int result = -n*m*2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int row1 = row[i];
                int col1 = col[i];
                int row0 = m - row[1];
                int col0 = n - col[1];
                int greyness = (row1 + col1) - (row0 + col0);
                result = Math.max(result, greyness);
            }
        }


        return result;
    }
}
