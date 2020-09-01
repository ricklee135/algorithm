package Exam.ZhongXing;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        char[] chars = {0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Map map = new HashMap();
        for(int j = 0;j < chars.length;j++){
            map.put(chars[j],j);
        }

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int[] rows = new int[row];
        for(int i = 0; i < row; i++){
            String str = sc.next();
            int l = sc.nextInt();
            int r = sc.nextInt();
            for(int k = l; k <= r;k++){
                if(l > chars.length){
                    //(int)map.get(str.charAt(str.length() - 1));
                    System.out.println();
                }
            }
        }

    }
}
