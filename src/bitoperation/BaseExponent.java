package bitoperation;

import java.util.Scanner;

public class BaseExponent {
    private static double myPower(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double temp = base;
        double result = 1;
        int e = Math.abs(exponent);
        while (e > 0){
            if((e & 1) == 1){
                result *= temp;
            }
            e = e >> 1;
            temp = temp * temp;
        }
        if(exponent > 0){
            return result;
        }else {
            return 1 / result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        int exponent = sc.nextInt();
        System.out.println(myPower(base, exponent));

    }
}
