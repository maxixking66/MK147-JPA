package ir.maktabsharif.jpa;

public class JpaApplication {

    static void main() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());


        long start = System.currentTimeMillis();
        MyThread thread1 = new MyThread();
        thread1.start();

        long end = System.currentTimeMillis();


        System.out.println(end - start);
    }

    private static void doTask1() {
        System.out.println("Task1 in thread name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doTask2() {
        System.out.println("Task2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doTask3() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task3");
    }
}

class MyThread extends Thread {

    public MyThread() {
        super("myThreadName-" + (int) (Math.random() * 10));
    }

    @Override
    public void run() {
        System.out.println("run method in my thread class, thread name: " + Thread.currentThread().getName());
    }
}