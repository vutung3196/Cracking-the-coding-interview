package blind75.graph.clonegraph;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

// Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraphBFS(Node node) {
        if (node == null) return node;

        HashMap<Node, Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // start the BFS traversal
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }

                // add neighbor of the original node to the cloned node
                visited.get(currentNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    public static Node cloneGraphDFS(Node node) {
        // TODO
    }
}
