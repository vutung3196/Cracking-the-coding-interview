package ElementsOfProgrammingInterview.chapter11Heaps.Exercise1TopKLongestStrings;

import java.util.*;

public class Solution {
    public static List<String> topKLongestStrings(int k, String[] iter) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String element : iter) {
            minHeap.add(element);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        String[] a = new String[] { "ahaha", "ah", "a                   c", "b         ", "a                   b"};
        var result = topKLongestStrings(1, a);
        for (var ab : result) {
            System.out.println(ab);
        }
    }
}
