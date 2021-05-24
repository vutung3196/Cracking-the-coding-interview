package Chapter4.TreesAndGraphs.Exercise1RouteBetweenNodes;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * Using DFS
 */
public class Solution {
    enum State {Unvisited, Visited, Visiting}

    private static State[] states;

    private static boolean isThereARoute(Digraph digraph, int startVertex, int endVertex) {
        if (startVertex == endVertex) return true;
        LinkedList<Integer> q = new LinkedList<>();
        states = new State[digraph.V()];
        for (int i = 0; i < digraph.V(); i++) {
            states[i] = State.Unvisited;
        }
        states[startVertex] = State.Visiting;
        q.add(startVertex);
        int currentVertex;
        while (!q.isEmpty()) {
            currentVertex = q.removeFirst();
            for (int vertex : digraph.adj(currentVertex)) {
                if (states[vertex] == State.Unvisited) {
                    if (vertex == endVertex) return true;
                    else {
                        states[vertex] = State.Visiting;
                        q.add(vertex);
                    }
                }
            }
            states[currentVertex] = State.Visited;
        }
        return false;
    }

    public static void main(String[] args) {
        var digraph = new Digraph(new In("src/Chapter4/TreesAndGraphs/Exercise1/tinyDG.txt"));
        System.out.println(isThereARoute(digraph, 12, 4));
    }
}
