package LeetCodeTopics.graph.unionfind.redundantconnection;

import LeetCodeTopics.graph.unionfind.UnionFind;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        // Construct the disjoint set here
        UnionFind uf = new UnionFind(1000 + 1);
        for (int[] edge : edges) {
            if (!uf.union_set(edge[0], edge[1])) return edge;
        }

        return null;
    }
}
