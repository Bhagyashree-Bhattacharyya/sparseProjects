package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo  {
    public static void main(String[] args) throws InterruptedException{
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        for(int i = 0; i < 200; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
//    try {
//        Thread.sleep(200);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//    executorService.shutdownNow();
//    executorService.submit(task);
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(2);
        Task task2 = new Task();
        executorService2.schedule(task2, 1, TimeUnit.MINUTES);

        System.out.println("I am in main last line");
    }
}
