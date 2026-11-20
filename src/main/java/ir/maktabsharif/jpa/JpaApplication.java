package ir.maktabsharif.jpa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JpaApplication {

    static int counter = 0;

    static void main() throws InterruptedException {
        Lock lock = new ReentrantLock(true);

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                try {
//                    if (!lock.tryLock()) {
                    if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                        throw new RuntimeException("lotfan baddan");
                    }
                    generateReport();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println(counter);

    }

    public static void increment() {
        counter++;
    }

    public static void generateReport() {

    }

}

