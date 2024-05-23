package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryConsistencyDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        TaskForMemoryConsIssue task1 = new TaskForMemoryConsIssue("W");
        TaskForMemoryConsIssue task2 = new TaskForMemoryConsIssue("R");
// different copies of data is kept in different registers to use by different thread(task)
        service.submit(task1);
        service.submit(task2);
        service.shutdown();
    }
}
