package MultiThreading;


class MyThreadDemo extends Thread{
    @Override
    public void run(){
        for (int i=0; i < 5; i++) {
            System.out.println(i + " printed by " + Thread.currentThread().getName());
        }
    }
}

class myRunnableDemo implements Runnable{
    @Override
    public void run(){
        for (int i=0; i < 5; i++) {
            System.out.println(i + " printed by " + Thread.currentThread().getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThreadDemo threadDemo1 = new MyThreadDemo();
        threadDemo1.start();

        myRunnableDemo runnable = new myRunnableDemo();
        Thread threadDemo2 = new Thread(runnable);
        threadDemo2.start();
//        threadDemo2.run();

        for (int i=0; i < 5; i++) {
            System.out.println(i + " printed by " + Thread.currentThread().getName());
//            System.out.println(); //sout
        }
    }
}
