package CompaniesInterview;

import java.util.concurrent.atomic.AtomicInteger;

public class Airplane {
    private AtomicInteger totalNumberOfLongMessages = new AtomicInteger(0);

    public void incrementLongMessages() {
        System.out.println("BEFORE");
        System.out.println(totalNumberOfLongMessages);
        totalNumberOfLongMessages.incrementAndGet();
        System.out.println("AFTER");
        System.out.println(totalNumberOfLongMessages);
        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        Airplane example = new Airplane();
        example.incrementLongMessages(); // This will increment the value by 1
    }
}