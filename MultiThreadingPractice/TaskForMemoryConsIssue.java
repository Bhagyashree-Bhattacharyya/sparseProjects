package MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskForMemoryConsIssue implements Runnable{
    private String type;
//    volatile static int data = 0; // best solution of memory inconsistency -- keep data in memory not register
    static int data = 0;
//    static AtomicInteger data = new AtomicInteger(0); // no interference of registers -- as objects never stays in registers

    public TaskForMemoryConsIssue(String type){
        this.type = type;
    }

    @Override
    public void run() {
        if(type.equalsIgnoreCase("W")){
            while (data != 5) {
                data++;
                System.out.println("newly wrote data : " +data);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            int temp = 0;
            while(true){
                if (temp != data){
                    System.out.println("read data : " + data);
                    temp = data;
                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}
