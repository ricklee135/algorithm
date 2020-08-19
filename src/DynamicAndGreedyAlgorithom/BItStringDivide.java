package DynamicAndGreedyAlgorithom;

import java.util.Scanner;

/*链接：https://ac.nowcoder.com/acm/contest/7190/A
来源：牛客网
题目描述
  牛妹有一个01{01}01串，串中只包含0{0}0和1{1}1，牛妹要把这个串划分成连续的m{m}m段，使得每一段至少包含一个0{0}0和一个1{1}1。         牛妹想最大化m{m}m，m{m}m最大是多少呢？
输入描述:
输入包含一行一个01{01}01串S{S}S。保证中至少包含一个0{0}0和一个1{1}1。
输出描述:
输出一行一个整数表示答案。
*
* */
public class BItStringDivide {
   /*  private static int getMaxSub(String s) {

        //other's method by subSting;greedy method
       while (j <= s.length()) {
            String b = s.substring(i, j);
            if (b.equals("01") || b.equals("10")) {
                m++;
                i = j;
                j = i + 2;
            } else if (b.equals("11") || b.equals("00")) {
                i++;
                j = i + 2;
            }
        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //my method by two pointers
        int m = 0, i = 0, j = i + 1;
        while (j < input.length() && i < input.length()) {
            if (input.charAt(j) != input.charAt(i)) {
                i = j + 1;
                j = i + 1;
                m++;
            }else {
                j++;
            }
        }
        System.out.println(m);
    }
}
