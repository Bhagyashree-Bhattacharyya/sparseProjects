package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialClient {
    public static void main(String[] args) {
//        List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> lst = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000);
        long startTime = System.currentTimeMillis();
        List<Thread> listOfThread = new ArrayList<>();
        lst.stream().forEach(item -> {
            MultiTreadedFactorial runnable = new MultiTreadedFactorial(item);
            Thread thread = new Thread(runnable);
            thread.start();
            listOfThread.add(thread);
//            try{
//                thread.join();
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
        });
        listOfThread.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken : " + (endTime - startTime) + " Miliseconds");
    }
}
