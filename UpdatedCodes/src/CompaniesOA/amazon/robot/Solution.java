package CompaniesOA.amazon.robot;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GG"));
    }

    private static boolean isRobotBounded(String instructions) {
        int[] positions = new int[]{0, 0};

        // directions north, sounth and west.
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {0, 1}};
        int face = 0;
    }
}
