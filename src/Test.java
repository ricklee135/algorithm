import java.io.*;
import java.util.*;

class Test{
    static final int N = 100010;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int idx = 0;

    public static void insert(int k, int v){
        e[idx] = v;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }

    public static void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        r[0] = 1;
        l[1] = 0;
        idx = 2;
        int k = 0, x = 0;
        for(int i = 0; i < m; i++){
            String s = sc.next();
            if(s.equals("L")){
                x = sc.nextInt();
                insert(0, x);
            }else if(s.equals("R")){
                x = sc.nextInt();
                insert(l[1], x);
            }else if(s.equals("D")){
                k = sc.nextInt();
                remove(k);
            }else if(s.equals("IL")){
                k = sc.nextInt();
                x = sc.nextInt();
                insert(l[k + 1], x);
            }else{
                k = sc.nextInt();
                x = sc.nextInt();
                insert(k + 1, x);
            }
        }
        for(int j = r[0]; j != 1; j = r[j]) System.out.print(e[r[j]] + " ");
    }
}