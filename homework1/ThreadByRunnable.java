package homework1;

public class ThreadByRunnable implements Runnable {
    public void run() {
        System.out.println("Create thread by implementing runnable");
    }

    public static void main(String[] args) {
        ThreadByRunnable tr = new ThreadByRunnable();
        new Thread(tr).start();
    }
}
