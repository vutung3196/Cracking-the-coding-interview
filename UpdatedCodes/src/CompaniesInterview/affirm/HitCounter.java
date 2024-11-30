package CompaniesInterview.affirm;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    private Queue<Integer> hits;

    public HitCounter() {
        this.hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - hits.peek();
            if (diff < 300) {
                break;
            } else {
                this.hits.remove();
            }

        }

        return this.hits.size();
    }

    public static void main(String[] args) {

    }

    class HitCounterOptimized {
        // Using a fixed-size array for O(1) operations
        private int[] times;
        private int[] hits;
        private static final int WINDOW = 300; // 5 minutes in seconds

        public HitCounterOptimized() {
            times = new int[WINDOW];
            hits = new int[WINDOW];
        }

        public void hit(int timestamp) {
            int index = timestamp % WINDOW;

            // If this is a new timestamp in this slot, reset the slot
            if (times[index] != timestamp) {
                times[index] = timestamp;
                hits[index] = 1;
            } else {
                // Increment hits for the existing timestamp
                hits[index]++;
            }
        }

        public int getHits(int timestamp) {
            int total = 0;

            // Sum hits within the 5-minute window
            for (int i = 0; i < WINDOW; i++) {
                // Check if the hit is within the last 5 minutes
                if (timestamp - times[i] < WINDOW) {
                    total += hits[i];
                }
            }

            return total;
        }
    }

}
