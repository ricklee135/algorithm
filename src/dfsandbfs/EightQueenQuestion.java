package dfsandbfs;

import java.util.Scanner;

class EightQueenQuestion {
    static int N = 20;
    static char[][] re = new char[N][N];
    static boolean[] c = new boolean[N];
    static boolean[] ls = new boolean[N];
    static boolean[] rs = new boolean[N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) re[i][j] = '.';
        }
        dfs(0);
    }

    //按行dfs
    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(re[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //枚举每行中每个元素
        for (int i = 0; i < n; i++) {
            if (!c[i] && !ls[u + i] && !rs[u - i + n]) {
                re[u][i] = 'Q';
                c[i] = ls[u + i] = rs[u - i + n] = true;
                dfs(u + 1);
                c[i] = ls[u + i] = rs[u - i + n] = false;
                re[u][i] = '.';
            }
        }
    }
}