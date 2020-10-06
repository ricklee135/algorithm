package string;

import java.util.Scanner;

public class KMPString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String p = " " + sc.next();
        int[] ne = new int[10];
        char[] p1 = p.toCharArray();
        for(int i = 2, j = 0; i <= n; i++){
            while (j != 0 && p1[j + 1] != p1[i]) j = ne[j];//不断调用前面的前缀进行匹配，直至找到合适的或者ne[0]
            if(p1[i] == p1[j + 1]) j++;
            ne[i] = j;
        }
        for(int i = 0; i < 10; i++) System.out.print(ne[i] + " ");
    }
}
