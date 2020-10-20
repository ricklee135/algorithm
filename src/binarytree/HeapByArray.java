package binarytree;

import java.io.*;

class HeapByArray{
    static int N = 100010;
    static int[] h = new int[N];
    static int[] hp = new int[N];
    static int[] ph = new int[N];
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = 0;

        for(int i = 0; i < n; i++){
            String[] op = bf.readLine().split(" ");
            if(op[0].equals("I")){
                int x = Integer.parseInt(op[1]);
                cnt++;
                m++;
                ph[m] = cnt;
                hp[cnt] = m;
                h[cnt] = x;
                up(cnt);
            }else if(op[0].equals("PM")) {
                System.out.println(h[1]);
            }else if(op[0].equals("DM")) {
                heapSwap(1, cnt);
                cnt--;
                down(1);
            }else if(op[0].equals("D")) {
                int k = Integer.parseInt(op[1]);
                k = ph[k];
                heapSwap(k, cnt);
                cnt--;
                down(k);
                up(k);
            }else{
                int k = Integer.parseInt(op[1]);
                int x = Integer.parseInt(op[2]);
                k = ph[k];
                h[k] = x;
                down(k);
                up(k);
            }
        }
        bf.close();
    }

    public static void swap(int[] nums, int k, int x){
        // if(k > nums.length - 1 || k < 0 || x < 0 || x > nums.length - 1) return;
        // else{
        int temp = nums[k];
        nums[k] = nums[x];
        nums[x] = temp;
    }


    public static void heapSwap (int k, int x){
        swap(ph, ph[hp[k]], ph[hp[x]]);
        swap(hp, hp[k], hp[x]);
        swap(h, k, x);
    }

    public static void down(int x){
        int t = x;
        if(2 * x <= cnt && h[2 * x] < h[t]) t = 2 * x;
        if(2 * x + 1 <= cnt && h[2 * x + 1] < h[t]) t = 2 * x + 1;
        if(t != x){
            heapSwap(x, t);
            down(t);
        }
    }

    public static void up(int k){
        while (k / 2 > 0 && h[k] < h[k / 2])
        {
            heapSwap(k, k / 2);
            k >>= 1;
        }
    }
}
