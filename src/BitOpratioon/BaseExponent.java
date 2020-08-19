package BitOpratioon;

import java.util.Scanner;

public class BaseExponent {
    private static double power(double base, int exponent) {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        double result = power(base,exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1)//0x1 转换为二进制为00000001，与运算判断是否为奇数
            result *= base;
        return result;
//        this is my answer
//        if(exponent == 0)
//            return 1.0;
//        if(exponent == 1)
//            return base;
//        double result = 1.0;
//        for(int i = 1; i <= exponent; i++){
//            result = result * base;
//        }
//        return base;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();
        int exponent = sc.nextInt();
        System.out.println(power(input, exponent));
    }
}
