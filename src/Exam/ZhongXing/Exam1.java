package Exam.ZhongXing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Exam1 {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int nextInt() throws Exception{
        in.nextToken();
        return (int) in.nval;
    }
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(System.in);
        int n = nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = nextInt();
        }
        long sum  = 0, max = 0;
        for(int i = 0,j; i < n; i++){
            for (j = i; j < n; j++){
                sum += nums[j];
                max = Math.max(sum / (j - i + 1),max);
            }
            sum = 0;
        }
        System.out.println(max);
    }
}
