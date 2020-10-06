package exam.huawei;

//思路，2的2n次方，用stack判断
//https://leetcode-cn.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(ans, sb, 0, 0, n);
        for (String str : ans) {
            System.out.println(str);
        }
    }

    public static void backtrack(List<String> ans, StringBuffer sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
        }
        if (open < n) {
            backtrack(ans, sb.append("("), open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            backtrack(ans, sb.append(")"), open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
