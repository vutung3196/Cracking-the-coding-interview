package neetcode150.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceTarget {
    private List<List<Integer>> result;
    private Map<Integer, List<Integer>> graph;
    private int target;

    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graphInput) {
        this.graph = new HashMap<>();
        for (int v = 0; v < graphInput.length; v++) {
            graph.putIfAbsent(v, new ArrayList<>());
            var currentList = graph.get(v);
            for (var u: graphInput[v]) {
                currentList.add(u);
            }
        }

        this.target = graphInput.length - 1;
        var path = new ArrayList<Integer>();
        path.add(0);
        backtrack(0, path);
        return result;
    }

    public void backtrack(int current, List<Integer> path) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (var neighbor : graph.get(current)) {
            path.add(neighbor);
            backtrack(neighbor, path);
            path.remove(path.size() - 1);
        }
    }
}
