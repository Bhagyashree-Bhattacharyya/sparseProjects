package MultiThreading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class FactorialDemo {

    public static void main(String[] args) {
        // nq > 10000
        List<Integer> lst = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000);
        long startTime = System.currentTimeMillis();
        lst.stream().parallel().map(item -> getFactorial(item)).forEach(item -> System.out.println(item));
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken : " + (endTime - startTime) + " Miliseconds");
    }

    public static BigInteger getFactorial(int num){
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}


