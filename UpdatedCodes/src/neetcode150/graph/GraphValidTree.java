package neetcode150.graph;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if (edges.length != n - 1) return false;
        UF uf = new UF(n);
        for (var edge : edges) {
            uf.union(edge[0], edge[1]);
            if (uf.isCycle()) {
                return false;
            }
        }
        return uf.getCount() == 1;
    }

    private class UF {
        int[] root;
        int[] rank;
        int count;
        boolean isCycle;

        public UF(int size) {
            root = new int[size];
            rank = new int[size];
            isCycle = false;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = size;
        }

        public int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            } else {
                isCycle = true;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public boolean isCycle() {
            return isCycle == true;
        }

        public int getCount() {
            return count;
        }
    }
}
