package dfsandbfs.matrix;

import java.util.*;
//5 5
//0 1 0 0 0
//0 1 0 1 0
//0 0 0 0 0
//0 1 1 1 0
//0 0 0 1 0
class DfsMaze{
    static int N = 110;
    static int[][] g = new int[N][N];
    static int[][] d = new int[N][N];
    static int n;
    static int m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                g[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;
        q.offer(new Pair(0, 0));
        int[] nex = {1, 0, -1, 0};
        int[] ney = {0, 1, 0, -1};
        while(q.size() > 0){
            Pair t = q.poll();//返回第一个元素并在队列中删除
            for(int i = 0; i < 4; i++){
                int x = t.first + nex[i];
                int y = t.second + ney[i];
                if(x >= 0 && x < n && y >= 0 && y < m && d[x][y] == -1 && g[x][y] == 0){
                    d[x][y] = d[t.first][t.second] + 1;
                    q.offer(new Pair(x, y));
                }
            }
        }
        return d[n - 1][m - 1];
    }

}

class Pair{
    public int first;
    public int second;
    public Pair(int i, int j){
        this.first = i;
        this.second = j;
    }
}