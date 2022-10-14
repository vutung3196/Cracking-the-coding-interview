package CompaniesOA.amazon.gridconnection;

import java.util.ArrayList;

public class Solution {
    /**
     * Grid Climbing: A grid with mrows and n columns is used to form a cluster of nodes.
     * If a point in the grid has a value of 1, then it represents a node.
     * Each node in the cluster has a level associated with it.
     * A node located in the throw of the grid is a level inode.
     * Here are the rules for creating a cluster:
     * Every node at level /connects to all the nodes at level k where > i and kis the first level after level i that contains at least 1 node.
     * • When i reaches the last level in the grid, no more connections are possible. . Given such a grid, find the number of connections present in the cluster.
     * Example: gridOfNodes = [[1, 1, 1], [0, 1, 0], [0, 0, 0],[1,1, 0]] .
     * • Row 1 to row 2: o Each of the three nodes in the first row connects to the single node in the second row: 3 connections. Row 2 to row 4: There is no node in row 3 so it is skipped.
     * • The single node in the second row connects to each of the two nodes in the last row: 2 connections. There are a total of 3 + 2 = 5 connections. Function Description Complete the numberOfConnections function in the editor below. The function must return a integer denoting the number of connections.

     */
    public static void main(String[] args) {
        var gridOfNodes = new ArrayList<ArrayList<Integer>>();
        gridOfNodes.add(new ArrayList<>(){{add(1); add(1); add(1);}});
        gridOfNodes.add(new ArrayList<>(){{add(0); add(0); add(0);}});
        gridOfNodes.add(new ArrayList<>(){{add(1); add(1); add(0);}});

        var result = numberOfConnections(gridOfNodes);
        System.out.println(result);
    }

    // Similar problem: 2125. Number of Laser Beams in a Bank: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
    private static int numberOfConnections(ArrayList<ArrayList<Integer>> gridOfNodes) {
        int result = 0, previousRow = 0, count = 0;
        for (ArrayList<Integer> gridOfNode : gridOfNodes) {
            count = 0;
            // loop through each element in the grid
            for (Integer integer : gridOfNode) {
                if (integer == 1) {
                    count++;
                }
            }

            if (count > 0) {
                result += count * previousRow;
                previousRow = count;
            }
        }

        return result;
    }
}
