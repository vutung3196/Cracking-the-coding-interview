package neetcode150.graph;

import java.util.*;

public class CheckPathExist {
    public static void main(String[] args) {

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges == null) {
            return false;
        }

        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (var edge : edges) {
            var s = edge[0];
            var dest = edge[1];
            graph.get(s).add(dest);
            graph.get(dest).add(s);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, boolean[] visited,
                        int currNode, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currNode);
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr == destination) return true;
            visited[curr] = true;
            for (var neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen,
                        int currNode, int destination) {
        if (currNode == destination) return true;

        if (!seen[currNode]) {
            seen[currNode] = true;
            for (var neighbor : graph.get(currNode)) {
                if (dfs(graph, seen, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
