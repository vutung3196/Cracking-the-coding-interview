package companies.trendmicro.codilitytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFunction {
    public static void main(String[] args) {
        List<Long> numbers = generateLongNumbers(100, 10000000);
        double standardDeviation = calculateStandardDeviation(numbers);

        System.out.println("Standard Deviation: " + standardDeviation);
    }

    public static List<Long> generateLongNumbers(int count, long minValue) {
        List<Long> numbers = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            long number = minValue + random.nextInt(10_000_000); // Adding a random value to ensure variety
            numbers.add(number);
        }
        return numbers;
    }

    public static double calculateStandardDeviation(List<Long> numbers) {
        int n = 0;
        double mean = 0.0;
        double m2 = 0.0;

        for (long number : numbers) {
            n++;
            double delta = number - mean;
            mean += delta / n;
            double delta2 = number - mean;
            m2 += delta * delta2;
        }

        if (n < 2) {
            return Double.NaN; // Not enough data points to calculate standard deviation
        }

        double variance = m2 / (n - 1);
        return Math.sqrt(variance);
    }
}
