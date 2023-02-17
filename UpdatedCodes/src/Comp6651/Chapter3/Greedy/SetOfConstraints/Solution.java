package Comp6651.Chapter3.Greedy.SetOfConstraints;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        var n = 6;
        var m1 = 4;
        var m2 = 5;
        var eqConstraints = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 5}
        };
        var ineqConstraints = new int[][]{
                {0, 4},
                {1, 4},
                {2, 4},
                {3, 4},
            };
        var result = solve(n, m1, m2, eqConstraints, ineqConstraints);
        System.out.println(Arrays.toString(result));
    }

    public static boolean solve(boolean[][] constraints) {
        int n = constraints.length;
        int[] values = new int[n]; // initialize all variables to be unassigned

        // process all the equality constraints
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (constraints[i][j]) {
                    if (values[i] == 0 && values[j] == 1) return false; // inconsistent
                    if (values[i] == 1 && values[j] == 0) return false; // inconsistent
                    if (values[i] == 0 && values[j] == 0) {
                        values[i] = 0;
                        values[j] = 0;
                    }
                    if (values[i] == 1 && values[j] == 1) {
                        values[i] = 1;
                        values[j] = 1;
                    }
                }
            }
        }

        // process all the inequality constraints
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!constraints[i][j]) {
                    if (values[i] == 0 && values[j] == 0) {
                        values[i] = 0;
                        values[j] = 1;
                    }
                    if (values[i] == 1 && values[j] == 1) {
                        values[i] = 0;
                        values[j] = 1;
                    }
                    if (values[i] == 0 && values[j] == 1) continue;
                    if (values[i] == 1 && values[j] == 0) continue;
                }
            }
        }

        // check if all constraints are satisfied
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (constraints[i][j]) {
                    if (values[i] != values[j]) return false;
                }
                if (!constraints[i][j]) {
                    if (values[i] == values[j]) return false;
                }
            }
        }

        // output the satisfying assignment
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + values[i]);
        }

        return true;
    }



    /**
     * You are given a set of m constraints over n Boolean variables x(1) , . . . , x(n) . The con-
     * straints are of two types:
     * • equality constraints: x(i) = x(j) for some i ̸= j;
     * • inequality constraints: x(i)  != x(j) for some i ̸= j.
     * Design an efficient greedy algorithm that given the set of equality and inequality con-
     * straints determines if it is possible or not to satisfy all the constraints simultaneously. If
     * it is possible to satisfy all the constraints, your algorithm should output an assignment
     * to the variables that satisfies all the constraints.
     * @param n number of variables
     * @param m1 number of equality constraints
     * @param m2 number of inequality constraints
     * @param M1 equality constraints boolean[][]
     * @param M2 inequality constraints boolean[][]
     * each constraint is represented by a pair of variables
     *       * @return a satisfying assignment or null if no such assignment exists
     */
    public static int[] solve(int n, int m1, int m2, int[][] M1, int[][] M2) {
        int[] S = new int[n]; // initialize all variables to be unassigned

        // process all the equality constraints
        for (int i = 0; i < m1; i++) {
            int x = M1[i][0];
            int y = M1[i][1];
            if (S[x] == 0 && S[y] == 1) return null; // inconsistent
            if (S[x] == 1 && S[y] == 0) return null; // inconsistent
            if (S[x] == 0 && S[y] == 0) {
                S[x] = 0;
                S[y] = 0;
            }
            if (S[x] == 1 && S[y] == 1) {
                S[x] = 1;
                S[y] = 1;
            }
        }

        // process all the inequality constraints
        for (int i = 0; i < m2; i++) {
            int x = M2[i][0];
            int y = M2[i][1];
            if (S[x] == 0 && S[y] == 0) {
                S[x] = 0;
                S[y] = 1;
            }
            if (S[x] == 1 && S[y] == 1) {
                S[x] = 0;
                S[y] = 1;
            }
//            if (S[x] == 0 && S[y] == 1) continue;
//            if (S[x] == 1 && S[y] == 0) continue;
        }

        // check if all constraints are satisfied
        for (int i = 0; i < m1; i++) {
            int x = M1[i][0];
            int y = M1[i][1];
            if (S[x] != S[y]) return null;
        }
        for (int i = 0; i < m2; i++) {
            int x = M2[i][0];
            int y = M2[i][1];
            if (S[x] == S[y]) return null;
        }


        return S;
    }
}
