package CompaniesInterview.affirm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoanTracker {
    private List<LoanEntry> loans;

    public LoanTracker() {
        loans = new ArrayList<>();
    }

    public void store_loan(double volume) {
        loans.add(new LoanEntry(volume, System.currentTimeMillis()));
    }

    public double get_loan_volume() {
        long oneHourAgo = System.currentTimeMillis() - 3600000; // 1 hour = 3,600,000 ms
        return loans.stream()
                .filter(loan -> loan.timestamp >= oneHourAgo)
                .mapToDouble(loan -> loan.volume)
                .sum();
    }

    private static class LoanEntry {
        double volume;
        long timestamp;

        LoanEntry(double volume, long timestamp) {
            this.volume = volume;
            this.timestamp = timestamp;
        }
    }

    static class LoanOptimize {
        private static final int BUCKET_COUNT = 60; // One bucket per minute
        private double[] volumeBuckets;
        private long lastUpdateTime;

        public LoanOptimize() {
            volumeBuckets = new double[BUCKET_COUNT];
            lastUpdateTime = System.currentTimeMillis();
        }

        public void store_loan(double volume) {
            long currentTime = System.currentTimeMillis();
            int currentBucket = getCurrentBucket(currentTime);

            // Reset buckets if time has passed
            if (currentTime - lastUpdateTime >= 3600000) {
                Arrays.fill(volumeBuckets, 0);
                lastUpdateTime = currentTime;
            }

            volumeBuckets[currentBucket] += volume;
        }

        public double get_loan_volume() {
            return Arrays.stream(volumeBuckets).sum();
        }

        private int getCurrentBucket(long currentTime) {
            return (int)((currentTime / 60000) % BUCKET_COUNT);
        }
    }
}
