package ir.maktabsharif.jpa;

public class JpaApplication {

    public static final Object global_lock = new Object();

    static void main() throws InterruptedException {
        Counter counter = new Counter();
        Counter counter1 = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 200_000; i++) {
                counter.increment();
            }
        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.get());

    }

}

class Counter {
    private int counter = 0;

    final Object lock = new Object();

    public void increment() {
        synchronized (JpaApplication.global_lock) {
            counter++;
        }
    }

//    public synchronized void increment() {
//        counter++;
//    }

    static final Object testLock = new Object();
    static final Object test2Lock = new Object();

    public static void test() {
        synchronized (testLock) {
            System.out.println();
        }
    }

    public static void test2() {
        synchronized (test2Lock) {
            System.out.println();
        }
    }

    public int get() {
        return counter;
    }
}