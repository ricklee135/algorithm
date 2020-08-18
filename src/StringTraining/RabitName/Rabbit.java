package StringTraining.RabitName;

import java.util.Scanner;

public class Rabbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] name = new String[n];
        String[] lovely = new String[m];
        for (int i = 0; i < n; i++) {
            String str1 = sc.next();
            name[i] = str1;
        }
        for (int i = 0; i < m; i++) {
            String str2 = sc.next();
            lovely[i] = str2;
        }
        //System.out.println(name.toString());

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (include(lovely[j],name[i])) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    private static boolean include(String s, String t) {
        int len_s = s.length(), len_t = t.length();
        int pointer_s = 0, pointer_t = 0;
        while (pointer_s < len_s && pointer_t < len_t) {
            if (s.charAt(pointer_s) == t.charAt(pointer_t)) {
                pointer_s++;
            }
            pointer_t++;
        }
        return pointer_s == len_s;
    }
}

