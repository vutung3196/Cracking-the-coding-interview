package LeetCodeTopics.graph.unionfind.numberofprovinces;

import LeetCodeTopics.graph.unionfind.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }


    // O(n^2) time complexity
    // O(n) space complexity
    public int findCircleNum(int[][] isConnected) {
        // Using Union-find algorithm
        // 1: Directly connected => same provinces
        // 0: Indirectly connected => not in the same provinces
        boolean[] visit = new boolean[isConnected.length];
        int numberOfConnectedComponents = 0;
        int length = isConnected.length;
        // loop through each node and dfs
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfConnectedComponents;
    }

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }

    public void bfs(int node, int[][] isConnected, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        visit[node] = true;
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public int findCircleNumUF(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int result = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    result--;
                    uf.union_set(i, j);
                }
            }
        }
        return result;
    }
}

