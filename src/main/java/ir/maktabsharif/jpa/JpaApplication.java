package ir.maktabsharif.jpa;

public class JpaApplication {

    static void main() throws InterruptedException {

        Box box = new Box();

        Thread producer = new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        String msg = "message-" + i;
                        try {
                            box.put(msg);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("put " + msg);
                    }
                },
                "producer"
        );
        Thread consumer = new Thread(
                () -> {
                    for (int i = 1; i <= 5; i++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println("took " + box.take());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, "consumer"
        );

        producer.start();
        consumer.start();

//        producer.join();
//        consumer.join();
    }

}

class Box {

    private String item;

    public synchronized void put(String item) throws InterruptedException {
        while (this.item != null) {
            this.wait();
        }
        this.item = item;
        notify();
    }

    public synchronized String take() throws InterruptedException {
        while (this.item == null) {
            wait();
        }
        String myItem = this.item;
        this.item = null;
        notify();
        return myItem;
    }
}