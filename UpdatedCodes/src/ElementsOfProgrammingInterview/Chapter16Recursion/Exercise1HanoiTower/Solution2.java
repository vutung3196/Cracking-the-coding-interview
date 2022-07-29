package ElementsOfProgrammingInterview.Chapter16Recursion.Exercise1HanoiTower;

import java.util.*;

public class Solution2 {
    // Main idea
    // Using the 3 rings transfer to successfully transfer 4 rings
    private static final int NUM_PEGS = 3;

    public static void computeTowerHanoi(int numRings) {
        // initialize
        List<Deque<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < NUM_PEGS; i++) {
            pegs.add(new LinkedList<>());
        }
        int[] a = new int[10];
        Integer[] A = new Integer[10];
        var b = A.length;

        for (int i = numRings; i >= 1; i--) {
            pegs.get(0).addFirst(i);
        }
        // main function
        computeTowerHanoiSteps(numRings, pegs, 0, 1, 2);
    }

    private static void computeTowerHanoiSteps(int numRingsToMove, List<Deque<Integer>> pegs, int fromPeg, int toPeg, int usePeg) {
        if (numRingsToMove > 0) {
            computeTowerHanoiSteps(numRingsToMove - 1, pegs, fromPeg, usePeg, toPeg);
            var dishToMove = pegs.get(fromPeg).removeFirst();
            pegs.get(toPeg).addFirst(dishToMove);
            System.out.println("Move from peg " + fromPeg + " to peg " + toPeg);
            computeTowerHanoiSteps(numRingsToMove - 1, pegs, usePeg, toPeg, fromPeg);
        }
    }

    public static void main(String[] args) {
        computeTowerHanoi(100);
    }
}
