package Chapter4DynamicProgramming.MatrixMultiplication;

public class Solution {
    public static void main(String[] args) {
        var input2 = new int[] {50, 20, 1, 10, 100};

        // correct answer
        System.out.println(solve(input2));
        System.out.println(solve_divide_conquer(input2));

        // incorrect answer
        System.out.println(matrix_chain_recursive(input2, 0, 5));
    }

    public static int solve(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            D[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                D[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = D[i][k] + D[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (q < D[i][j]) {
                        D[i][j] = q;
                    }
                }
            }
        }
        return D[0][n - 1];
    }

    public static int solve_divide_conquer(int[] dimensions) {
        int n = dimensions.length;
        int[][] s = new int[dimensions.length][dimensions.length];
        return matrix_chain_greedy(dimensions, 1, n-1, s);
    }

    public static int solve_new(int[] dimensions) {
        return matrix_recursive(dimensions, 0, dimensions.length - 1);
    }

    public static int matrix_recursive(int[] dimensions, int i, int j) {
        // base case
        if (i == j) return 0;

        // finding k where pi * pj * pk small
        var minValue = Integer.MAX_VALUE;
        int k = 0;
        for (int f = i+1; f < j; f++) {
            if (dimensions[i] * dimensions[f] * dimensions[j] < minValue) {
                k = f;
                minValue = dimensions[i] * dimensions[f] * dimensions[j];
            }
        }
        var result = 0;
        // found k;
        int leftValue = matrix_recursive(dimensions, i, k);
        int rightValue = matrix_recursive(dimensions, k + 1, j);
        result += leftValue + rightValue + dimensions[i] * dimensions[k] * dimensions[j];
        return result;
    }

    public static int matrix_chain_greedy(int[] dimensions, int i, int j, int[][] s) {
        if (i == j) return 0;
        s[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            var q = matrix_chain_greedy(dimensions, i, k, s) + matrix_chain_greedy(dimensions, k + 1, j, s)
                    + dimensions[i-1]*dimensions[k]*dimensions[j];
            if (q < s[i][j]) s[i][j] = q;
        }

        return s[i][j];
    }

    public static int matrix_chain_mixed(int[] dimensions) {
        int n = dimensions.length;
        int minCost = Integer.MAX_VALUE;
        int p0 = dimensions[0];
        int pn = dimensions[n-1];
        int k = 0;
        for (int j = 1; j < n; j++) {
            var currentValue = p0 * dimensions[j] * pn;
            if (currentValue < minCost) {
                minCost = currentValue;
                k = j;
            }
        }
        var result = 0;
        int leftCost = matrix_chain_recursive(dimensions, 0, k);
        int rightCost = matrix_chain_recursive(dimensions, k, n);
        result = leftCost + rightCost + p0 * dimensions[k] * pn;
        return result;
    }

    public static int call_matrix_chain_recursive(int[] dimensions) {
        return matrix_chain_recursive(dimensions, 0, dimensions.length );
    }

    public static int matrix_chain_recursive_official(int[] dimensions, int i, int j) {
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        int optimalK = 0;
        // finding k where p0 x pk x pn is minimum
        for (int k = i; k < j; k++) {
            if (dimensions[i] * dimensions[k] * dimensions[j] < minCost) {
                minCost = dimensions[i] * dimensions[k] * dimensions[j];
                optimalK = k;
            }
        }

        minCost = dimensions[i] * dimensions[optimalK] * dimensions[j];
        var leftCost = matrix_chain_recursive_official(dimensions, i, optimalK);
        var rightCost = matrix_chain_recursive_official(dimensions, optimalK + 1, j);
        minCost += leftCost + rightCost;
        return minCost;
    }

    public static int matrix_chain_recursive(int[] dimensions, int i, int j) {
        if (i == j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int leftCost = matrix_chain_recursive(dimensions, i, k);
            int rightCost = matrix_chain_recursive(dimensions, k, j);
            int totalCost = leftCost + rightCost + dimensions[i] * dimensions[k] * dimensions[j-1];

            if (totalCost < minCost) {
                minCost = totalCost;
            }
        }

        return minCost;
    }

}
