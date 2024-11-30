package companies.trendmicro.codilitytest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversallyRecommended {
    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        String[] recommendations = {"1 2", "2 3", "3 4"};

        int result = universallyRecommended(N, M, recommendations);
        System.out.println("Universally Recommended Students: " + result);
    }

    public static int universallyRecommended(int N, int M, String[] recommendations) {
        // construct the graph first
        List<Set<Integer>> graph = new ArrayList<>(N+1);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new HashSet<>());
        }

        for (var recommendation : recommendations) {
            var nodes = recommendation.split(" ");
            var from = Integer.parseInt(nodes[0]);
            var to = Integer.parseInt(nodes[1]);
            graph.get(from).add(to);
        }

        for (int i = 1; i <= N; i++) {
            Set<Integer> recommendedBy = new HashSet<>();
            dfs(graph, i, recommendedBy, new boolean[N+1]);
            graph.get(i).addAll(recommendedBy);
        }

        int universallyConnected = 0;
        for (int student = 1; student <= N; student++) {
            boolean isRecommendedAll = true;
            for (int recommender = 1; recommender <= N; recommender++) {
                if (recommender != student && !graph.get(recommender).contains(student)) {
                    isRecommendedAll = false;
                    break;
                }
            }

            if (isRecommendedAll) {
                universallyConnected++;
            }
        }

        return universallyConnected;
    }

    public static void dfs(List<Set<Integer>> graph, int current, Set<Integer> recommendedBy, boolean[] visited) {
        visited[current] = true;

        for (var recommend : graph.get(current)) {
            if (!visited[recommend]) {
                recommendedBy.add(recommend);
                dfs(graph, recommend, recommendedBy, visited);
            }
        }
    }


    public static int universallyRecommended2(int N, int M, String[] recommendations) {
        // Construct the graph here!!
        List<Set<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new HashSet<>());
        }

        for (String recommendation : recommendations) {
            String[] parts = recommendation.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.get(from).add(to);
        }

        // compute transitive closure
        // starting from index 1
        for (int i = 1; i <= N; i++) {
            Set<Integer> recommendedBy = new HashSet<>();
            dfs2(graph, i, recommendedBy, new boolean[N+1]);
            graph.get(i).addAll(recommendedBy);
        }

        int universallyRecommended = 0;
        for (int student = 1; student <= N; student++) {
            boolean isRecommendedAll = true;

            // check if it is recommended by all students
            for (int recommender = 1; recommender <= N; recommender++) {
                if (recommender != student && !graph.get(student).contains(recommender)) {
                    isRecommendedAll = false;
                    break;
                }
            }

            if (isRecommendedAll) {
                universallyRecommended++;
            }
        }

        return universallyRecommended;
    }

    private static void dfs2(List<Set<Integer>> graph, int current,
                            Set<Integer> recommendedBy, boolean[] visited) {
        visited[current] = true;
        for (var recommend : graph.get(current)) {
            if (!visited[recommend]) {
                recommendedBy.add(recommend);
                dfs2(graph, recommend, recommendedBy, visited);
            }
        }
    }
}
