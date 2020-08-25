package homework1;

public class ThreadByThread extends Thread{

    public void run() {
        System.out.println("Create a new Thread by extending Thread");
    }
    public static void main(String[] args) {
        new ThreadByThread().start();
    }
}
