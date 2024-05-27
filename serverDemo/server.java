package serverDemo;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    public static void main(String[] args) {
        System.out.println("Enter the input - ");
        Scanner sc = new Scanner(System.in);
        ExecutorService service = Executors.newFixedThreadPool(4);
        while(true){
            String data = sc.nextLine();
            if(data.equalsIgnoreCase("exit")){
                System.exit(0);
//                service.shutdown();
                break;
            }
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Running with "+data+" on thread "+Thread.currentThread().getName());
                }
            });
        }
    }
}
