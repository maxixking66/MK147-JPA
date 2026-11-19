package ir.maktabsharif.jpa;

public class JpaApplication {


    static void main() throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
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

    public synchronized void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}