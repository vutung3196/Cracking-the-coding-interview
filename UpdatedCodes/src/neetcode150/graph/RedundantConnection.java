package neetcode150.graph;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        var uf = new UnionFind(1000+1);
        for (int[] edge : edges) {
            if (!uf.union_set(edge[0], edge[1])) return edge;
        }

        return null;
    }


    private class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }

            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union_set(int x, int y) {
            int x_set = find(x);
            int y_set = find(y);

            if (x_set == y_set) {
                return false;
            } else if (rank[x_set] < rank[y_set]) {
                parent[x_set] = y_set;
            } else if (rank[x_set] > rank[y_set]) {
                parent[y_set] = x_set;
            } else {
                parent[y_set] = x_set;
                rank[x_set]++;
            }

            return true;
        }

    }
}
