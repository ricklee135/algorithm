package bitoperation;

import java.util.Scanner;

public class CountOneInBinary {
    private static int times(int n) {
        int count = 0;
        while (n > 0) {
            //通过与运算判断是否为奇数 1 & 0 = 0
            if ((n & 1) == 0)
                count++;
            n = n >> 1;
        }
        return count;
    }

    private static int times2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);//在上个解法中，无用操作就是，如果当前位是0，还会判断，然后一位一位移动，
            // 该方法直接掠过0的判断。
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(times(n));
    }
}
