package ir.maktabsharif.jpa;

import java.util.Random;

public class JpaApplication {

    static final Random RAND = new Random();

    static void main() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(
                getCustomerDashboard(823746328)
        );
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    private static CustomerDashboardData getCustomerDashboard(long customerId) {
        return new CustomerDashboardData(
                getNumberOfAccounts(customerId),
                getChqBookRequests(customerId),
                getReturnedChqs(customerId),
                getNumberOfLoans(customerId)
        );
    }

    private static long getNumberOfAccounts(long customerId) {
        sleep(RAND.nextLong(500, 5000));
        return RAND.nextLong(0, 10);
    }

    private static long getChqBookRequests(long customerId) {
        sleep(RAND.nextLong(500, 5000));
        return RAND.nextLong(0, 10);
    }

    private static long getReturnedChqs(long customerId) {
        sleep(RAND.nextLong(500, 5000));
        return RAND.nextLong(0, 10);
    }

    private static long getNumberOfLoans(long customerId) {
        sleep(RAND.nextLong(500, 5000));
        return RAND.nextLong(0, 10);
    }

    private static CustomerChqBookRequests getData(long customerId) {
//        this is query
        long total = RAND.nextLong(0, 10);
//        this is query
        long delivered = RAND.nextLong(0, 10);
        return new CustomerChqBookRequests(total, delivered);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}

record CustomerDashboardData(long numberOfAccounts, long chqBookRequests, long returnedChqs, long numberOfLoans) {

}

record CustomerChqBookRequests(long total, long delivered) {

}