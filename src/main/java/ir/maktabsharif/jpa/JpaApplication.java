package ir.maktabsharif.jpa;

public class JpaApplication {

    static int counter = 0;

    static void main() throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                increment();
            }
        };
//      start task
//      i = 0;
//      if i < 100_000 -> true
//      counter++;
//        th1
//      counter = 100_000;
//      counter = counter + 1;
//        counter = 100_001
//        th2
//      counter = 100_000;
//      counter = counter + 1;
//        counter = 100_001


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

//        Thread.sleep(100000);
        t1.join();
        t2.join();


        System.out.println(counter);

    }

    public synchronized static void increment() {
        counter++;
    }


}