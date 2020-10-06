package dfsandbfs;


import java.util.Scanner;

public class Hanio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        hanio(input,'x','y','z');
    }

    private static void hanio(int input, char x, char y, char z) {
        if(input == 1){
            System.out.println(x + "->" + z);
            return;
        }else{
            hanio(input-1,x,z,y);
            System.out.println(x + "->" + z );
            hanio(input - 1,y,x,z);
        }
    }
}
