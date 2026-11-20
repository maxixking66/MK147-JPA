package ir.maktabsharif.jpa;

public class JpaApplication {

    static final Object first = new Object(), second = new Object();

    static void main() throws InterruptedException {
        new Thread(
                () -> {
                    synchronized (first) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (second) {
                            System.out.println("t1 OK");
                        }
                    }
                }, "t1"
        ).start();
        new Thread(
                () -> {
                    synchronized (second) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (first) {
                            System.out.println("t2 OK");
                        }
                    }
                }, "t2"
        ).start();
    }

}

