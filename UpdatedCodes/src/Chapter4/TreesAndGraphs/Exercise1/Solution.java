package Chapter4.TreesAndGraphs.Exercise1;

import java.util.*;

public class Solution {
    private static boolean isThereARoute(Node root) {
        Queue<Node> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            Node currentNode = treeNodes.poll();
            if (currentNode != null) {
                if (currentNode.havingRoute) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }

    private class Node {
        public boolean havingRoute;
        public String name;
        public Node[] children;
    }
}
