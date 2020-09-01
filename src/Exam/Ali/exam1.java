package Exam.Ali;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class exam1 {
    static StreamTokenizer  in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static Long nextLong() throws Exception{
        in.nextToken();
        return (long) in.nval;
    }
    public static void main(String[] args) throws Exception{
        long A = nextLong();
        long B = nextLong();
        long a = nextLong();
        //int m = (int) nextLong();
        long b = nextLong();
        System.out.println(A);System.out.println(B);
        //System.out.println(m);//x (A)* b = Y(b) * a ,max X * y 1 - A xuan x 1- b xuan y
//        if (A * b < a || a * B < b) {
//            System.out.println(0 + " " + 0);
//        }
       /* long max1 = 0;
        int temp;
        long a, b = 1;
        for (a = 1; a < A; a++) {
            b = a * y / x;
            while (b <= B && a * y == b * x) {
                a++;
            }
            max1 = Math.max(max1, a * b);
        }
        System.out.println(a + " " + b);
    }*/}
/*作者：孤独的背包
链接：https://www.nowcoder.com/discuss/487527?type=all&order=time&pos=&page=1&channel=1009&source_id=search_all
来源：牛客网

import java.util.*;public class Main{
    public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt()){
    long A = input.nextLong();
    long B = input.nextLong();
    long a = input.nextLong();
    long b = input.nextLong();
     long start = Math.min(A, (B*a)/b);
     for (long i = start; i >= 1 ; i--) {
     if((b*i)%a == 0 && (b*i)/a <= B){
      long y = (b*i)/a;
       System.out.println(i + " " + y);
        break;
         }
          }
           }
           }*/

}
