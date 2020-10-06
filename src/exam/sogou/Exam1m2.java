package exam.sogou;


import java.util.Scanner;

public class Exam1m2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//输入题目数
        int k = sc.nextInt();//输入小明作对的题目数
        String s1 = sc.next();//你的答案
        //char s = sc.next();
        String s2 = sc.next();//小明的答案
        int same = 0, diff = 0;
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) == s2.charAt(i)){
                same++;//你和小明答案中相同的个数
            }else {
                diff++;//。。。不同的个数
            }
        }
        System.out.println(Math.max(0, k - diff));//最小做对题目数，s + k - n = k - (n - s) = k - diff
        System.out.println(Math.min(k, same) + Math.min(diff, n - k));//最大做对题目数
    }
}
