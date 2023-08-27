package LeetCodeTopics.graph.unionfind.stonesremovedwithsamerow;

import LeetCodeTopics.graph.unionfind.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int removeStones(int[][] stones) {
        // On a 2D plane, we place n stones at some integer coordinate points, each coordinate point may have at most one stone
        // A stone can be removed if it shares either the same row or the same column as another stone that has not been removed
//        var size = stones.length;
//        int result = size;
//        UnionFind uf = new UnionFind(size);
//        for (var stone : stones) {
//            if (!uf.union_set(stone[0], stone[1])) {
//                result--;
//            }
//        }
//
//        return result;
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int[] stone1 : stones) {
            if (!visited.contains(stone1)) {
                dfs(stone1, visited, stones);
                numOfIslands++;
            }
        }

        return stones.length - numOfIslands;
    }

    private void dfs(int[] stone1, Set<int[]> visited, int[][] stones) {
        visited.add(stone1);
        for (int[] stone2: stones) {
            if (!visited.contains(stone2)) {
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    dfs(stone2, visited, stones);
                }
            }
        }
    }
}
