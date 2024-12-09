package neetcode150.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarliestMoment {
    public static void main(String[] args) {
        int[][] logs = {
                {9, 3, 0},
                {0, 2, 1},
                {8, 0, 1},
                {1, 3, 2},
                {2, 2, 0},
                {3, 3, 1}
        };

        int n = 4;
        EarliestMoment em = new EarliestMoment();
        System.out.println(em.earliestAcq(logs, n));

    }

    public int earliestAcq(int[][] logs, int n) {
        if (logs == null || logs.length == 0) {
            return -1;
        }

        // sort the timestamp
        List<Log> logList = new ArrayList<>();
        for (var log : logs) {
            logList.add(new Log(log[0], log[1], log[2]));
        }

        Collections.sort(logList);
        UnionFind uf = new UnionFind(n);
        for (var log : logList) {
            int time = log.time;
            uf.union(log.a, log.b);
            if (uf.getCount() == 1) {
                return time;
            }
        }

        return -1;
    }

    private class Log implements Comparable<Log> {
        int time;
        int a;
        int b;

        public Log(int time, int a, int b) {
            this.time = time;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Log other) {
            return Integer.compare(this.time, other.time);
        }
    }

    private class UnionFind {
        int[] root;
        int[] rank;
        int count;

        // O(n)
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
            count = size;
        }

        // O(n)
        public int find(int x) {
            if (x != root[x]) {
                root[x] = find(root[x]);
            }

            return root[x];
        }

        // O(n)
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
            }
        }

        // O(n)
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }
    }
}
