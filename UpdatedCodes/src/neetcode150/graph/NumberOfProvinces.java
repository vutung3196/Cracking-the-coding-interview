package neetcode150.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {

    }

    public int findCircleNumUF(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return -1;
        }

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    private static int findCircleNum(int[][] connectedMap) {
        // 1: directly connected: same province
        // 0: indirectly connected: not in the same province
        boolean[] visit = new boolean[connectedMap.length];
        int numberOfProvinces = 0;
        for (int i = 0; i < connectedMap.length; i++) {
            if (!visit[i]) {
                numberOfProvinces++;
                bfs(i, connectedMap, visit);
            }
        }
        return numberOfProvinces;
    }

    private static void bfs(int node, int[][] connectedMap, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        visit[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int polledNode = queue.poll();
            for (int i = 0; i < connectedMap.length; i++) {
                if (connectedMap[polledNode][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static void dfs(int node, int[][] connectedMap, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < connectedMap.length; i++) {
            if (connectedMap[node][i] == 1 && !visit[i]) {
                dfs(i, connectedMap, visit);
            }
        }
    }
}
