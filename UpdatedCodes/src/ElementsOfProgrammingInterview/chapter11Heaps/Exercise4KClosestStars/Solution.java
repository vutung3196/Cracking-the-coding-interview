package ElementsOfProgrammingInterview.chapter11Heaps.Exercise4KClosestStars;

import java.util.*;

/**
 * Consider a coordinate system for the Milky Way in which Earth is at (0,0,0). <br>
 * Model stars as points, and assume distances are in light years. The Milky Way consists of <br>
 * approximately 1012 stars, and their coordinates are stored in a file. <br>
 * How would you compute the k stars which are closest to Earth? <br>
 * Hint:Suppose you know the k closest stars in the first n stars. If the (n + l)th star is to be added <br>
 * to the set of k closest stars, which element in that set should be evicted?
 */
public class Solution {
    public static class Star implements Comparable<Star> {
        public Star(String name, double x, double y, double z) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        private String name;
        private double x, y, z;

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star that) {
            return Double.compare(this.distance(), that.distance());
        }

        @Override
        public String toString() {
            return this.name + ": " + this.distance();
        }
    }

    /**
     * Time complexity: O(n*Log(K))
     * @param k number of closest stars
     * @param stars iterator of stars
     * @return
     */
    public static List<Star> findKClosestStars(int k, Iterator<Star> stars) {
        // using max heap
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while (stars.hasNext()) {
            var currentStar = stars.next();
            maxHeap.add(currentStar);
            if (maxHeap.size() > k) {
                // poll furthest element
                maxHeap.poll();
            }
        }
        var result = new ArrayList<>(maxHeap);
        // sort one ore time
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star("1", 3, 1, 4));
        stars.add(new Star("2", 2, 1, 3));
        stars.add(new Star("3", 1, 1, 2));
        stars.add(new Star("4", 2, 1, 1));
        stars.add(new Star("5", 0, 1, 2));
        var iterator = stars.iterator();
        var result = findKClosestStars(2, iterator);
        for (var i : result) {
            System.out.println(i);
        }
    }
}
