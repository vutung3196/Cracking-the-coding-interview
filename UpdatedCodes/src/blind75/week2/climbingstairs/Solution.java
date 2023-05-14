package blind75.week2.climbingstairs;

public class Solution {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
       int[] D = new int[n+1];
       D[1] = 1;
       D[2] = 2;
        for (int stair = 3; stair <= n; stair++) {
            D[stair] = D[stair - 1] + D[stair - 2];
        }

        return D[n];
    }
}
