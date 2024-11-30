package companies.trendmicro.codilitytest;

import java.util.*;

public class GraphColoring {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("8 5", "1 3", "3 4", "4 6", "4 5", "1 2", "2 9", "2 8", "1 1 6", "1 1 8", "2 1 6");
        List<Integer> result = processOperations(input);
        System.out.println(result); // Expected: [number of black segments in path 1 to 6]
    }

    public static List<Integer> processOperations(List<String> input) {
        String[] firstLine = input.get(0).split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] isBlack = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] edge = input.get(i).split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = n + 1; i < input.size(); i++) {
            String[] operation = input.get(i).split(" ");
            int opType = Integer.parseInt(operation[0]);
            int a = Integer.parseInt(operation[1]);
            int b = Integer.parseInt(operation[2]);

            if (opType == 1) {
                changeColor(graph, isBlack, a, b, true);
                changeColor(graph, isBlack, a, b, false);
            } else if (opType == 2) {
                int blackSegments = countBlackSegments(graph, isBlack, a, b);
                results.add(blackSegments);
            }
        }

        return results;
    }

    private static void changeColor(List<List<Integer>> graph, boolean[] isBlack, int start, int end, boolean toBlack) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isBlack.length];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (toBlack) {
                isBlack[node] = true;
            } else {
                isBlack[node] = false;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }

            if (node == end) {
                break;
            }
        }
    }

    private static int countBlackSegments(List<List<Integer>> graph, boolean[] isBlack, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[isBlack.length];
        queue.add(start);
        visited[start] = true;

        int blackSegments = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (isBlack[node]) {
                blackSegments++;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }

            if (node == end) {
                break;
            }
        }

        return blackSegments;
    }
}

