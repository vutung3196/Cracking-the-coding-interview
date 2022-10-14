package CompaniesOA.amazon.robot;

public class Solution {

    // link: https://leetcode.com/problems/robot-bounded-in-circle/
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }

    private static boolean isRobotBounded(String instructions) {
        // using the number 0, 1, 2 and 3 for the directions
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // initial position is in the center
        int x = 0, y = 0;

        // facing north
        int idx = 0;

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'L') {
                idx = (idx + 3) % 4;
            } else if (instruction == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        return (x == 0 && y == 0) || (idx != 0);
    }
}
