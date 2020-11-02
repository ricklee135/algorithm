package dfsandbfs.dijkstra;

import java.util.*;
import java.io.*;

class MinPath {
    static int N = 510;
    static int[][] g = new int[N][N];
    static int[] d = new int[N];
    static boolean st[] = new boolean[N];
    static int n;
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        for(int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        Arrays.fill(d, INF);

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            g[a][b] = Math.min(c, g[a][b]);
        }
        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        d[1] = 0;
        for(int i = 1; i < n - 1; i++) {
            int t = -1;//记录当前已经确定的最短路径的点
            //寻找当前未访问过的最短边
            for(int j = 1; j <= n; j++) {
                if(!st[j] && (t == -1 || d[t] > d[j]))
                    t = j;
            }
            st[t] = true;
            //确定当前点到起始点的最小值
            for(int j = 1; j <= n; j++) d[j] = Math.min(d[j], d[t] + g[t][j]);//Integer.MAX_VALUE会溢出
        }
        return d[n];
    }
}
