package recursive;

import java.util.Scanner;

public class Fibonacci1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        System.out.println(getNthFibonacci(n));
    }

    private static long getNthFibonacci(long n) {
        int[] result = {0, 1};
        if(n < 2){
            return result[(int)n];
        }
        long fibOne = 1;
        long fibTwo = 0;
        long temp = 0;
        //在该方法中，temp存储了每个小于n的整数对应的fibonacci的值，
        for(long i = 2; i <= n; i++){
            temp = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = temp;
        }
        return temp;
    }
}
