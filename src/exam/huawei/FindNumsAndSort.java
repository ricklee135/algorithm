package exam.huawei;

import java.util.*;
/*
    字符串中提取数字从小到大排列
    一开始做复杂了，考虑了多位数……没想到直接提取就完事了……

*/
public class FindNumsAndSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length();i++){
            if(!check(input.charAt(i))){
                continue;
            }else
            {
                list.add((input.charAt(i) - '0'));
            }

        }
        Collections.sort(list);
        Collections.reverse(list);
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    private static boolean check(char charAt) {
        if(charAt >= '0'&& charAt <= '9'){
            return true;
        }
        return false;
    }

}
