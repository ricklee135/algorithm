package DynamicAndGreedyAlgorithom.GetMaxMountainSubarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


//一个字符串s被称作另一个字符串S的子串，表示s在S中出现了。一个字符串s被称作另一个字符串S
//的子序列，说明从序列S通过去除某些元素但不破坏余下元素的相对位置（在前或在后）可得到序列s。
/*题目描述
https://www.nowcoder.com/practice/2818df3e10c44f859e49048875a71d34
众所周知，牛妹是一个offer收割姬，这次面试她遇到了这样的一个问题。
给了一个序列，让找出最长的“凸子序列”
何为“凸子序列”：数列中有一个xi,使得所有x0<x1<x2….xi-1<xi且xi>xi+1>xi+1>….>xn
eg：12345431,是山峰序列，12345234不是山峰序列
注：单调递增或单调递减序列也算山峰序列；单独一个数是长度为1的山峰序列*/

public class LengthOfMaxMountainSubArray {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        int l = nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = nextInt();
        }
        System.out.println(mountainSequence(nums));
    }

    public static int mountainSequence(int[] numberList) {
        int l = numberList.length;
        int[] dp1 = new int[l];
        int[] dp2 = new int[l];

        for (int i = 0; i < numberList.length; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numberList[j] < numberList[i])
                    dp1[i] = Math.max(dp1[i],dp1[j] + 1);
            }
        }
        for (int i = l - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = l - 1; j > i; j--) {
                if (numberList[j] < numberList[i])
                    dp2[i] = Math.max(dp2[i],dp2[j] + 1);
            }
        }
        int max = 0;
        for(int i = 0; i < l; i++){
            max =Math.max(max,dp1[i] + dp2[i] - 1) ;
        }
        return max;
        //理解题意错误，以下方法可以用来求最大子串。
/*        for (int i = 0, j; i < l; i = j) {
            j = i + 1;
            while (j < l && numberList[i] > numberList[j]) {
                j++;
            }
            dp[i] = j - i;
        }
        for (int i = l - 1, j; i >= 0; i = j) {
            j = i - 1;
            while (j >= 0 && numberList[i] > numberList[j]) {
                j--;
            }
            dp[i] += i - j - 1;
        }*/

    }
}
