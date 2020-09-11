package Exam.xiaomi;

import java.util.Scanner;

public class MIMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String [] sArray = str.split(" ");
        for(int i = 0; i < sArray.length;i++){
            if(sArray[i].length() >= 8 && sArray.length <= 120){

                if(isDifferent(sArray[i])){
                    System.out.println("0");
                }else {
                    System.out.println("2");
                }
            }else {
                System.out.println("1");
            }

        }
    }

    private static boolean isDifferent(String c) {
        int count = 0;
        if(c.replaceAll("[a-z]" , "").length() > 0);
            count += 1;
        if(c.replaceAll("[A-Z]","").length() > 0)
            count += 1;
        if(c.replaceAll("[0-9]","").length() > 0)
            count += 1;
        if(c.replaceAll("[a-z,A-Z,0-9]","").length() > 0)
            count += 1;
        if(count == 4){
            return  true;
        }
        return false;
    }
}
