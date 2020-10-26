package string;

import java.io.*;

class StringHash{

    static int N = 100010;
    static int P = 131;
    static long mod = Long.MAX_VALUE;
    static long[] h = new long[N];
    static long[] p = new long[N];


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] values = br.readLine().split(" +");//\\" +"按照空格拆分，\\s+按空白部分（包含多个空格）进行拆分
        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        String t = br.readLine();

        p[0] = 1;
        for(int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + t.charAt(i - 1) - 'A';
            p[i] = p[i - 1] * P;
        }
        for(int i = 0; i < m; i++){
            String[] v = br.readLine().split("\\s+");
            int l1 = Integer.parseInt(v[0]);
            int r1 = Integer.parseInt(v[1]);
            int l2 = Integer.parseInt(v[2]);
            int r2 = Integer.parseInt(v[3]);
            bw.write(get(l1,r1) == get(l2,r2) ? "Yes" : "No");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static long get(int l, int r){
        return  h[r] - h[l - 1] * p[r - l + 1];
    }
}
