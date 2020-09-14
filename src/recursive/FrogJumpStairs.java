package recursive;

import java.util.Scanner;

public class FrogJumpStairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int stairs = s.nextInt();
        System.out.println(getJumpMethods(stairs));
    }

    private static int getJumpMethods(int stairs) {
       if(stairs <= 2){
           return stairs;
       }
       return getJumpMethods(stairs - 1) + getJumpMethods(stairs - 2);
    }
}
