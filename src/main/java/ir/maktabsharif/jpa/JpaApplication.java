package ir.maktabsharif.jpa;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JpaApplication {

    static final Object first = new Object(), second = new Object();

    static void main() throws InterruptedException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {

            Runnable task = () -> {
                System.out.println("task started by " + Thread.currentThread().getName() + " in " + LocalDateTime.now());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("task ended by " + Thread.currentThread().getName() + " in " + LocalDateTime.now());
            };

            for (int i = 0; i < 20; i++) {
                Future<?> future = executorService.submit(task);
//                future.get();
            }
        } /*catch (ExecutionException e) {
            throw new RuntimeException(e);
        }*/
    }

}

