package neetcode150.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceTarget {
    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graphInput) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int v = 0; v < graphInput.length; v++) {
            graph.putIfAbsent(v, new ArrayList<>());
            var currentList = graph.get(v);
            for (var u: graphInput[v]) {
                currentList.add(u);
            }
        }


        // find all possible paths connecting from 0 to n - 1

    }
}
