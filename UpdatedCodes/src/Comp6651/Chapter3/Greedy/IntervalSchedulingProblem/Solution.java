package Comp6651.Chapter3.Greedy.IntervalSchedulingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    // greedy approach
    public static int[][] solveGreedy(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = Integer.MIN_VALUE;
        var list = new ArrayList<int[]>();
        for (var interval : intervals) {
            if (interval[0] >= end) {
                count++;
                list.add(interval);
                end = interval[1];
            }
        }
        var arr = list.toArray(new int[list.size()][]);
        return arr;
//        return count;
    }
}
