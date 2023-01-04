package CompaniesInterview.palantir.courseschedule2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    public static class Graph {
        // number of vertices in the graph
        public int V;
        // number of edges in the graph
        public int E;

        public List<Integer>[] adj;

        public int[] indegree; // inDegree[i] == in degree of vertex v

        /**
         * Add the directed edge v->w to the graph
         **/
        public void addEdge(int v, int w) {
            adj[v].add(w);
            indegree[w]++;
            E++;
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            indegree = new int[V];
            adj = (ArrayList<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }
    }

    public static class DirectedCycle {
        private boolean[] marked;
        private int[] edgeTo;
        private boolean[] onStack; // is vertex on the stack
        private Stack<Integer> cycle;

        public DirectedCycle(Graph graph) {
            marked = new boolean[graph.V];
            onStack = new boolean[graph.V];
            edgeTo = new int[graph.V];
            for (int v = 0; v < graph.V; v++) {
                if (!marked[v] && cycle == null)
                    dfs(graph, v);
            }
        }

        private void dfs(Graph graph, int v) {
            onStack[v] = true;
            marked[v] = true;

            for (int w : graph.adj(v)) {
                if (cycle != null) return;
                else if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(graph, w);
                } else if (onStack[w]) {
                    cycle = new Stack<>();
                    for (int x = v; x != w ; x = edgeTo[x]) {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // detecting a cycle in a graph, if yes => return false: impossible to finish all courses
        // return true => can finish all courses
        // initialize the course
        var graph = new Graph(numCourses);

        for (var edge : prerequisites) {
            var firstNode = edge[0];
            var secondNode = edge[1];
            graph.addEdge(firstNode, secondNode);
        }

        // detect the DAG in the graph
        // if no topological sort => no cycle in the graph
        var directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) return false;
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if containing cycle in the graph => return null

        return null;
    }
}
