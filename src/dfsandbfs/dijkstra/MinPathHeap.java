package dfsandbfs.dijkstra;

import java.util.*;
import java.io.*;

public class MinPathHeap {


        static int N = 150010;
        static int n, idx;
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int[] h = new int[N];
        static int[] w = new int[N];
        static int[] d = new int[N];
        static boolean[] st = new boolean[N];

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            Arrays.fill(h, -1);
            for(int i = 0; i < m; i++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int z = Integer.parseInt(str[2]);
                add(x, y, z);
            }
            System.out.println(dijkstra());
            //for(int i = 0; i <= n; i++) System.out.println(w[i]);
        }

        public static void add(int a, int b, int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }

        public static int dijkstra() {
            Queue<Pair> q = new PriorityQueue<>();
            Arrays.fill(d, 0x3f3f3f3f);
            q.offer(new Pair(0, 1));
            d[1] = 0;
            while(!q.isEmpty()){
                Pair t = q.poll();
                int distance = t.first, node = t.second;
                if(st[node]) continue;
                st[node] = true;
                for(int i = h[node]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if(d[j] > d[node] + w[i]){
                        d[j] = d[node] + w[i];
                        q.offer(new Pair(j, d[j]));
                    }
                }
            }
            return d[n] == 0x3f3f3f3f ? -1 : d[n];
        }



    static class Pair implements Comparable<Pair> {
        public int first;
        public int second;
        public Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
        public int compareTo(Pair p) {
            if(p.first < this.first) return 1;
            else return -1;
        }
    }
}
