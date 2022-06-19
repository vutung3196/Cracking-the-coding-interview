package ElementsOfProgrammingInterview.chapter11Heaps.Exercise2MergeSortedArrays;

import java.util.*;

public class Solution {
    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArray(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (var array : sortedArrays) {
            iters.add(array.iterator());
        }
        // create new min heap
        var minHeap = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        for (int i = 0; i < iters.size(); i++) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            var headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
