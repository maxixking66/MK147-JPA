package ir.maktabsharif.jpa;

public class JpaApplication {

    static void main() throws InterruptedException {
        Counter counter = new Counter();
        counter.increment();
        System.out.println(counter.get());
    }

}

class Counter {
    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
            this.print();
        }
    }

    public void print() {
        synchronized (this) {
            System.out.println("after increment");
        }
    }

    public int get() {
        return counter;
    }
}