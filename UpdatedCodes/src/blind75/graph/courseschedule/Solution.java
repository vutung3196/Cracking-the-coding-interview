package blind75.graph.courseschedule;
import java.util.*;
public class Solution {

    public static void main(String[] args) {

    }

    public static class Graph {
        // number of nodes
        public int V;

        // number of edges
        public int E;

        // list of adjacency edges for each node
        public List<Integer>[] adj;

        // inDegree[i] == in degree of vertex i
        public int[] inDegree;

        public void addEdge(int v, int w) {
            adj[v].add(w);
            inDegree[w]++;
            E++;
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            this.inDegree = new int[V];
            this.adj = (ArrayList<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<Integer>();
            }
        }
    }

    // initialize a directed cycle class
    public static class DirectedCycle {
        private boolean[] marked;
        private int[] edgeTo;
        private boolean[] onStack; // is the vertex on the stack
        private Stack<Integer> cycle;

        public DirectedCycle(Graph graph) {
            marked = new boolean[graph.V];
            onStack = new boolean[graph.V];
            edgeTo = new int[graph.V];
            for (int v = 0; v < graph.V; v++) {
                if (!marked[v] && cycle == null) {
                    dfs(graph, v);
                }
            }
        }

        private void dfs(Graph graph, int v) {
            onStack[v] = true;
            marked[v] = true;

            for (int w: graph.adj(v)) {
                if (cycle != null) return;
                else if (!onStack[w]) {
                    edgeTo[w] = v;
                    dfs(graph, w);
                } else if (onStack[w]) {
                    cycle = new Stack<>();
                    for (int x = v; x != w; x = edgeTo[x]) {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);
                }
            }
            onStack[v] = false;
        }

        public boolean hasCycle() {
            return cycle != null;
        }
    }

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * @param numCourse
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourse, int[][] prerequisites) {
        // build a graph
        var graph = new Graph(numCourse);
        for(var edge : prerequisites) {
            graph.addEdge(edge[0], edge[1]);
        }
        var directedCycle = new DirectedCycle(graph);
        return directedCycle.hasCycle();
    }

    // pair [0, 1], indicate that to take course 0, you have to take course 1 first
    public boolean canFinishV2(int numCourses, int[][] prerequisites) {
        // True if you can finish all courses, false otherwise
        // We will introduce an indegree array to check the degree of the nodes
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        // adding nodes
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }

        // adding edges
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            queue.offer(i);
        }
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (var neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }
}
