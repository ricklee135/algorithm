package exam.zhaoyinwangluo;

//思路，2的2n次方，用stack判断
//https://leetcode-cn.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackOutPutNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(ans, sb, 0, 0, n);
        Stack<Integer> s = new Stack<>();

        for (String str : ans) {
            int j = 1;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '1') {
                    s.push(j++);
                }
                if(str.charAt(i) == '0'){
                    System.out.print(s.pop());
                }
            }
            System.out.println();
        }
    }
    //通过该方法把n的不同情况入栈出栈的情况复刻出来，然后按照该顺序用栈进行输入输出
    public static void backtrack(List<String> ans, StringBuffer sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
        }
        if (open < n) {
            backtrack(ans, sb.append("1"), open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            backtrack(ans, sb.append("0"), open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
