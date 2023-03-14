package Comp6651.Chapter4DynamicProgramming.NonIntersectSecments;

import java.util.Arrays;

public class Solution {

    static class Segment implements Comparable<Segment> {
        int id, x1, x2;

        public Segment(int id, int x1, int x2) {
            this.id = id;
            this.x1 = x1;
            this.x2 = x2;
        }

        public int compareTo(Segment other) {
            return Integer.compare(x1, other.x1);
        }
    }
    public static void main(String[] args) {
        Segment[] segments = {
                new Segment(1, 0, 2),
                new Segment(0, 1, 3),
                new Segment(2, 2, 4),
                new Segment(3, 3, 5),
                new Segment(4, 4, 6),
                new Segment(5, 5, 1),
                new Segment(5, 7, 0)
        };

        var result = Solution(segments);
        System.out.println(result);
    }

    public static int Solution(Segment[] segments) {
        var n = segments.length;
        int[] S = new int[n];
        var result = 0;
        for (int i = 0; i < n; i++) {
            S[i] = 1;
        }
        // sort segments by x1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (segments[i].x2 >= segments[j].x2) {
                    S[i] = Math.max(S[i], 1 + S[j]);
                }
            }
            result = Math.max(result, S[i]);
        }

        for (int i = 0; i < n; i++) {
            if (S[i] > result) {
                result = S[i];
            }
        }

        return result;
    }

    // print solution here
    public static Segment[] SolutionPrintSegments(Segment[] segments) {
        var n = segments.length;
        int[] S = new int[n];
        var result = 0;
        Segment[] prev = new Segment[n];
        Arrays.fill(prev, null);
        for (int i = 0; i < n; i++) {
            S[i] = 1;
        }
        // sort segments by x1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (segments[i].x2 >= segments[j].x2) {
                    S[i] = Math.max(S[i], 1 + S[j]);
                    prev[i] = segments[j];
                }
            }
            result = Math.max(result, S[i]);
        }

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (S[i] > result) {
                result = S[i];
                maxIndex = i;
            }
        }

        Segment[] resultSegments = new Segment[maxIndex];
        int index = resultSegments.length - 1;
        while (maxIndex >= 0) {
            resultSegments[index] = segments[maxIndex];
            index--;
            maxIndex = prev[maxIndex];
        }

        return result;
    }
}
