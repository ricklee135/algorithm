package dynamicandgreedyalgorithom.rope;

import java.util.Scanner;

public class GreedyMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 2){
            System.out.println("invalid input");
        }
        if (n % 3 == 0){
            System.out.println(Math.pow(3, n / 3));
        }
        if (n % 3 == 1){
            System.out.println(Math.pow(3, n / 3 - 1) * 4);
        }
        if (n % 3 == 2){
            System.out.println(Math.pow(3, n / 3) * 2);
        }

    }
}
