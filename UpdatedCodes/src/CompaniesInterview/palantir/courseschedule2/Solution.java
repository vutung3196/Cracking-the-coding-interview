package CompaniesInterview.palantir.courseschedule2;

import java.util.*;

class Solution {
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

    public static class TopologicalOrder {
        private boolean[] marked;
        private int[] post;
        private Queue<Integer> postOrder;
        private int postCounter;
        private Stack<Integer> topologicalOrder;

        public TopologicalOrder(Graph graph) {
            marked = new boolean[graph.V];
            post = new int[graph.V];
            postOrder = new LinkedList<>();
            for (int v = 0; v < graph.V; v++) {
                if (!marked[v]) dfs(graph, v);
            }

            topologicalOrder = new Stack<>();
            for (int v : postOrder)
                topologicalOrder.push(v);
        }

        private void dfs(Graph graph, int v) {
            marked[v] = true;
            for (int w : graph.adj(v)) {
                if (!marked[w]) dfs(graph, w);
            }
            postOrder.add(v);
            post[v]  = postCounter++;
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

        public void findTopologicalOrder() {

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
    public int[] findOrder(int numCourse, int[][] prerequisites) {
        // build a graph
        var graph = new Graph(numCourse);
        for(var edge : prerequisites) {
            graph.addEdge(edge[0], edge[1]);
        }
        var directedCycle = new DirectedCycle(graph);
        if (directedCycle.hasCycle()) {
            return new int[0];
        } else {
            var topologicalOrder = new TopologicalOrder(graph);
            var order = topologicalOrder.topologicalOrder;
            for (int i : order) {
                System.out.println(i);
            }
            var result = new int[order.size()];
            for (int i = 0; i < order.size(); i++)
                result[i] = order.get(i);
            return result;
        }
    }
}