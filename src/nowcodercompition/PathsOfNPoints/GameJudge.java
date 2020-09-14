package nowcodercompition.PathsOfNPoints;


import java.util.Scanner;

public class GameJudge {
    //这里想的简单了，没有对4个node的情况进行推导就进行了奇偶性相关的判断
/*    private static int getPaths(int nodes){
        return (nodes)*(nodes - 1)/2;
    }
    private static String printAnswer(int n){
        if ((n & 0x1) == 1){
            return "Ulamog, the Infinite Gyre";
        }
        return "Kozilek, Butcher of Truth";
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nodes = new int[t];
        for(int i = 0; i < t; i++){
            nodes[i] = sc.nextInt();
            if(nodes[i] == 1){
                System.out.println("Kozilek, Butcher of Truth");
            }else {
                System.out.println("Ulamog, the Infinite Gyre");
            }
        }

    }
}

