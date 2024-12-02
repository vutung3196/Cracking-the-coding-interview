package companies.trendmicro.codilitytest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    /**
     * Calculates the number of students recommended by every other student
     *
     * @param N Number of students in the school (1 <= N <= 100)
     * @param M Number of explicit recommendations
     * @param recommendations Array of recommendation pairs
     * @return Number of students recommended by everyone
     */
    public static int calculateUniversallyRecommended(int N, int M, String[] recommendations) {
        // Create an adjacency list to represent recommendation graph
        List<Set<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new HashSet<>());
        }

        // Populate initial recommendations
        for (String rec : recommendations) {
            String[] parts = rec.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            graph.get(from).add(to);
        }

        // Compute transitive closure
        for (int i = 1; i <= N; i++) {
            Set<Integer> recommendedBy = new HashSet<>();
            dfs(graph, i, recommendedBy, new boolean[N + 1]);
            graph.get(i).addAll(recommendedBy);
        }

        // Count students recommended by everyone
        int universallyRecommended = 0;
        for (int student = 1; student <= N; student++) {
            boolean isRecommendedByAll = true;

            // check if it is recommended by all students
            for (int recommender = 1; recommender <= N; recommender++) {
                if (recommender != student && !graph.get(recommender).contains(student)) {
                    isRecommendedByAll = false;
                    break;
                }
            }

            if (isRecommendedByAll) {
                universallyRecommended++;
            }
        }


        return universallyRecommended;
    }

    /**
     * Depth-first search to compute transitive recommendations
     *
     * @param graph Recommendation graph
     * @param current Current student
     * @param recommendedBy Set to store transitive recommendations
     * @param visited Visited array to prevent cycles
     */
    private static void dfs(List<Set<Integer>> graph, int current,
                            Set<Integer> recommendedBy, boolean[] visited) {
        visited[current] = true;
        // explore all directly recommended students

        for (int recommend : graph.get(current)) {
            if (!visited[recommend]) {
                recommendedBy.add(recommend);
                dfs(graph, recommend, recommendedBy, visited);
            }
        }
    }

    // Example usage and test
    public static void main(String[] args) {
        // Test case from the problem statement
        int N = 3;
        int M = 3;
        String[] recommendations = {"1 2", "2 1", "2 3"};

        int result = calculateUniversallyRecommended(N, M, recommendations);
        System.out.println("Universally Recommended Students: " + result);

//        System.out.println(findNext(33));
    }

    // finding n = p ^ 2 +  (p + 1) ^ 2 + (p + 2) ^ 2 + (p + 3) ^ 2 + ... + (p +m) ^ 2
    public static String[] findSequences(int n) {
        var resultArray = new ArrayList<String>();
        int p = 1;
        while (Math.pow(p, 2) < n) {
            double currentSum = 0;
            int m = 0;
            // loop through every m
            while (currentSum < n) {
                currentSum += Math.pow(p + m, 2);
                if (currentSum == n) {
                    var sb = new StringBuilder();
                    sb.append((m + 1) + " ");
                    for (int i = 0; i < m + 1; i++) {
                        if (i == m) {
                            sb.append(p + i);
                        } else {
                            sb.append(p + i + " ");
                        }
                    }
                    resultArray.add(sb.toString());
                }
                m++;
            }
            p++;
        }

        var result = new ArrayList<String>();
        var length = resultArray.size();
        result.add(String.valueOf(length));
        result.addAll(resultArray);

        // convert result to array
        String[] finalResult = result.toArray(new String[0]);
        finalResult[0] = resultArray.size() + " ";
        return finalResult;
    }

    public static int findNext(int roseNumber) {
        if (multipleOfContaining7(roseNumber) || String.valueOf(roseNumber).contains("7")) {
            return -1;
        }

        int current = roseNumber + 1;
        while  ((multipleOfContaining7(current) || String.valueOf(current).contains("7"))
                && current > roseNumber) {
            current++;
        }

        return current;
    }

    public static boolean multipleOfContaining7(int number) {
        int start = 7;
        while (start < number) {
            if (number % start == 0) {
                return true;
            }
            start += 10;
        }
        return false;
    }

    public static int findNextNumber(int x) {
        int next = x + 1;

        while (true) {
            // Check if next number is valid to call
            if (!containsSeven(next) && !isMultipleOfSevenExcluded(next)) {
                return next;
            }
            next++;

            // Prevent infinite loop
            if (next > 1000) return -1;
        }
    }

    private static boolean containsSeven(int num) {
        return String.valueOf(num).contains("7");
    }

    private static boolean isMultipleOfSevenExcluded(int num) {
        for (int i = 2; i <= num/7; i++) {
            if (containsSeven(i * 7)) {
                return true;
            }
        }
        return false;
    }

    public static void main1(String[] args) {
        // Test cases
        System.out.println(findNext(7));   // Output: 8
        System.out.println(findNext(69));  // Output: 36
        System.out.println(findNext(300)); // Output: -1
    }
}
