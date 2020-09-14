package string.replace;

import java.util.Scanner;

public class ReplaceBlank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "1234567890";
        String strReplaced = str.replace(" ","%20");
        System.out.println(strReplaced);
        //System.out.println(str.length());
    }
}
