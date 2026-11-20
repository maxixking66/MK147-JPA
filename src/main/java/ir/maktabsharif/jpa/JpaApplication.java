package ir.maktabsharif.jpa;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JpaApplication {

    static int counter = 0;

    static void main() throws InterruptedException {

        Lock lock = new ReentrantLock();

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                try {
                    lock.lock();
                    increment();
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


}

