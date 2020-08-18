package BitOpratioon;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(times(n));
    }
}
