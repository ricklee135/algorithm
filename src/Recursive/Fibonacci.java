package Recursive;

import java.util.Scanner;

public class Fibonacci {
    //在递归过程中，想要求得f(10),需要求得f(9)和f(8)，想要求得f(9),需要求得f(8)和f(7)，这样的计算过程中，有很多节点被重复计算
    //重复计算的节点随着n的增大急剧增加，用递归方法计算的时间复杂度是以n的指数方式递增的。
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(getNthFibonacci(n));
    }

    private static int getNthFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
