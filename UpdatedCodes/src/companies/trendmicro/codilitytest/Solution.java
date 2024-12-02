package companies.trendmicro.codilitytest;

import java.util.*;

public class Solution {
    Map<Integer, List<Integer>> graph;
    int[] parent;

    public int[] solve(String[] input) {
        // Parse input
        String[] firstLine = input[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        // Build graph
        graph = new HashMap<>();

        // Add edges
        int maxKey = 0;
        for (int i = 1; i < n; i++) {
            String[] edge = input[i].split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }

            if (u > maxKey) {
                maxKey = u;
            }
            if (v > maxKey) {
                maxKey = v;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[maxKey+1];
        boolean[] visited = new boolean[maxKey+1];
        List<Integer> results = new ArrayList<>();

        // Track red/black segment status
        boolean[][] blackSegments = new boolean[maxKey+1][maxKey+1];

        // Process operations
        for (int i = n; i < n+m; i++) {
            String[] op = input[i].split(" ");
            int opi = Integer.parseInt(op[0]);
            int a = Integer.parseInt(op[1]);
            int b = Integer.parseInt(op[2]);

            // Find path between a and b
            List<Integer> path = findPath(a, b);

            if (opi == 1) {
                // Change connected segments to red
                for (int node : path) {
                    for (int neighbor : graph.get(node)) {
                        blackSegments[node][neighbor] = false;
                        blackSegments[neighbor][node] = false;
                    }
                    // Color path black
                    for (int j = 0; j < path.size() - 1; j++) {
                        blackSegments[path.get(j)][path.get(j+1)] = true;
                        blackSegments[path.get(j+1)][path.get(j)] = true;
                    }
                }
            } else {
                // Count black segments in path
                int blackCount = 0;
                for (int j = 0; j < path.size() - 1; j++) {
                    if (blackSegments[path.get(j)][path.get(j+1)]) {
                        blackCount++;
                    }
                }
                results.add(blackCount);
            }
        }

        // Convert results to array
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> findPath(int start, int end) {
        // Reset parent array
        Arrays.fill(parent, 0);

        // BFS to find path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                break;
            }

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != 0; at = parent[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample input matching the problem description
        String[] input = {
                "8 5",        // n (stations) and m (operations)
                "1 2",        // edge between station 1 and 2
                "1 3",        // edge between station 1 and 3
                "3 4",        // edge between station 3 and 4
                "4 5",        // edge between station 4 and 5
                "4 6",        // edge between station 4 and 6
                "2 8",        // edge between station 2 and 8
                "2 9",        // edge between station 2 and 9
                "1 1 6",      // Operation 1: modify segments between stations 1 and 6
                "1 2 4",      // Operation 1: modify segments between stations 2 and 4
                "2 1 6",      // Operation 2: count black segments between stations 1 and 6
                "1 1 5",      // Operation 1: modify segments between stations 1 and 5
                "2 2 6"       // Operation 2: count black segments between stations 2 and 6
        };

        int[] results = solution.solve(input);

        // Print results
        System.out.println("Results:");
        for (int result : results) {
            System.out.println(result);
        }
    }
}
