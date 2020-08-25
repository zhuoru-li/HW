package homework1;

public class Counter {
    private int counter = 0;

    public synchronized void increase() {
        System.out.println(Thread.currentThread().getName() + " " + counter++);
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increase();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increase();
            }
        }).start();
    }
}
