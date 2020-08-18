package BitOpratioon;

import java.util.Scanner;

/*链接：https://ac.nowcoder.com/acm/contest/7016/B
来源：牛客网

给出v, k，请你找到最小的正整数n，满足： n的二进制表示下存在
一个长度为v的回文串，该回文串首尾都是1且n的二进制表示中至少有
k个1。保证v,k均为偶数！ 由于n可能很大，你只需要输出对
109+710^9+7109+7取模的结果。*/
public class FindMin {
    private static int[] findMin(int v, int k) {
        if (v % 2 != 0 && k % 2 != 0) {
            return null;
        }
        if (v <= k)
            v = k;

        int[] binary = new int[v];
        binary[0] = 1;
        binary[binary.length - 1] = 1;
        for(int i = 0; i < k - 2; i++){
            binary[(v - k + 2) / 2 + i] = 1;//因为中间有k - 2 个值必须对称为1，找到第一个为1的索引，循环赋值
        }
//        int l_mid = k / 2; 这是我的方法，比较笨拙，中间向两边扩展赋值1
//        int r_mid = k / 2 + 1;
//        while (k > 0 && l_mid >= 0 && r_mid < binary.length) {
//            binary[l_mid] = 1;
//            binary[r_mid] = 1;
//            k -= 2;
//        }
        return binary;

    }

//    private static int decimalNumber(int[] binary) {这是我的计算二进制的方法
//        int dM = 0;
//        for (int i = 0; i < binary.length; i++) {
//            dM += binary[i] * Math.pow(2, binary.length - 1 - i);
//        }
//        return dM;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int k = sc.nextInt();
        int[] binary = findMin(v, k);
        int num = 0;
        for(int i = 0; i < binary.length; i++){
            /*附：为什么很多程序竞赛题目都要求答案对 1e9+7 取模？
            1000000007是一个质数
            int32位的最大值为2147483647，所以对于int32位来说1000000007足够大
            int64位的最大值为2^63-1，对于1000000007来说它的平方不会在int64中溢出
            所以在大数相乘的时候，因为(a∗b)%c=((a%c)∗(b%c))%c，所以相乘时两边都对
            1000000007取模，再保存在int64里面不会溢出*/
            num = (num * 2 + binary[i]) % (1000000000 + 7);
        }
        System.out.println(num);
    }
}
