package MultiThreading;

public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Bhagyashree " + Thread.currentThread());
    }
}
