package MultiThreading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

    public static void main(String[] args) {
        ThreadFactoryDemo demo = new ThreadFactoryDemo();

        Task task1 = new Task();
        Thread t1 = demo.newThread(task1);
        t1.start();

        Task task2 = new Task();
        Thread t2 = demo.newThread(task2);
        t2.start();

    }
}
