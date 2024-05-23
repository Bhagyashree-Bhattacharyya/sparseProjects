package MultiThreading;

import java.math.BigInteger;

public class MultiTreadedFactorial implements Runnable{
    private int num;

    public MultiTreadedFactorial(int num){
        this.num = num;
    }

    @Override
    public void run() {
        getFactorial();
    }

//    public int getFactorial(){
//        int result = 1;
//        for (int i = 2; i <= this.num; i++) {
//            result *= i;
//        }
//        System.out.println("Factorial of " + this.num + " is " + result + ", calculated by " + Thread.currentThread());
//        return result;
//    }

    public BigInteger getFactorial(){
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= this.num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial of " + this.num + " is " + ", calculated by " + Thread.currentThread());
        return result;
    }
}
