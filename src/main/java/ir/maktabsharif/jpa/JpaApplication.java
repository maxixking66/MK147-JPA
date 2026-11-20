package ir.maktabsharif.jpa;

public class JpaApplication {

    static int counter = 0;

    static void main() throws InterruptedException {

        SimpleLock lock = new SimpleLock();

        Runnable task = () -> {
            for (int i = 0; i < 50_000; i++) {
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

class SimpleLock {
    private static int counter = 0;
    private boolean locked = false;

    public synchronized void lock() {
        System.out.println(Thread.currentThread().getName() + " try to lock " + counter++);
        while (locked) {
            System.out.println(Thread.currentThread().getName() + " wait");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " took lock");
        locked = true;
    }

    public synchronized void unlock() {
        System.out.println(Thread.currentThread().getName() + " try to unlock");
        locked = false;
        notify();
        System.out.println(Thread.currentThread().getName() + " notify one thread");
    }
}