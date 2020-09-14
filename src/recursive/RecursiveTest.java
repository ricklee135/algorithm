package recursive;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursiveTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int input = s.nextInt();
        printOut(input);
    }

    private static void printOut(int input) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input >= 10) {
            printOut(input / 10);
            System.out.println(input / 10);
        }
    }
}
/*
输出结果为：
input:123456
output: 1
        12
        123
        1234
        12345

该test反映了递归的过程，先计算出的input/10 被压入栈中，递归结束后弹出，保持了输入的顺序
*/