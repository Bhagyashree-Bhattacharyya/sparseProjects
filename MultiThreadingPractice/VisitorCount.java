package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCount implements Runnable{
//    private int count;
    private AtomicInteger count; // takes care of multithreading internally

    public VisitorCount(){
//        this.count = 0;
        this.count = new AtomicInteger(0);
    }

    @Override
    public void run() {
//        count++;
//        addCount();
        count.getAndAdd(1);
    }


    // hinders parallelism, as threads waiting in the queue
//    public synchronized void addCount(){
//        count ++;
//    }

    public int getCount() {
//        return count;
        return count.get();
    }
}
