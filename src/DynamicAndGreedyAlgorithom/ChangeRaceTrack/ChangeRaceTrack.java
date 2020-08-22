package DynamicAndGreedyAlgorithom.ChangeRaceTrack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*链接：https://www.nowcoder.com/questionTerminal/85efab854e60499daa524ca943b72d35
来源：牛客网

牛牛准备在一个3行n列的跑道上跑步。一开始牛牛可以自己选择位于(1,1)还是(2,1)还是(3,1)。
  跑道的每一格都有一些金币，当牛牛跑到一个格子，他会获得这个格子的所有金币。  当牛牛位于
  第i行第j列时，他可以的下一步最多可能有三种选择：  1. 不花费金币跑到第i行第j+1列
  2. 花费mjm_jmj​的金币跑到第i-1行第j+1列（如果i=1则不可以这么跑）。 3. 花费mjm_
  jmj​的金币跑到第i+1行第j+1列（如果i=3则不可以这么跑）。 （牛牛是一个富豪，本身带了
  很多的金币，所以你不用担心他钱不够用）   现在告诉你所有格子的金币数量和每一列的金币花费，
  牛牛想知道他跑到第n列最多可以赚得多少金币（赚得金币=获得金币-消耗金币） */
public class ChangeRaceTrack {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int nextInt() throws Exception{
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) {
    }
    public int solve (int n, int[] a1, int[] a2, int[] a3, int[] m){
        int[][] dp = new int[3][n];
        int max;
        dp[0][0] = a1[0];
        dp[1][0] = a2[0];
        dp[2][0] = a3[0];
        for(int i = 1; i < n;i++){
            dp[0][i] = Math.max(dp[1][i - 1] - m[i - 1],dp[0][i - 1]) + a1[i];
            dp[1][i] = Math.max(dp[0][i - 1] - m[i - 1],Math.max(dp[1][i - 1],dp[2][i - 1] - m[i - 1])) + a2[i];
            dp[2][i] = Math.max(dp[2][i - 1],dp[1][i - 1] - m[i -1]) + a3[i];

            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]-m[i-1])+a1[i];
            dp[1][i]=Math.max(dp[1][i-1],Math.max(dp[0][i-1],dp[2][i-1])-m[i-1])+a2[i];
            dp[2][i]=Math.max(dp[2][i-1],dp[1][i-1]-m[i-1])+a3[i];
        }

        max = max(dp[0][n - 1],dp[1][n-1],dp[2][n - 1]);
        return max;

    }
        /*public int solve (int n, int[] a1, int[] a2, int[] a3, int[] m) {
            // write code here
            //int[] index = new int[n];
            int[][] race = new int[3][n];
            int total = max(race[0][0],race[0][1],race[0][2]);;
            for(int i = 0; i < a1.length; i++){
                race[0][i] = a1[i];
                race[1][i] = a2[i];
                race[2][i] = a3[i];
            }
            int row = 1,col,index;

            while(row < n){

                index = getindex(race[row], max(race[row][0],race[row][1],race[row][2]));
                if(index == 0){
                    total += Math.max(race[row + 1][index + 1] - m[index + 1],race[row + 1][index]);
                }else if(index == 1){
                    total += max(race[row + 1][index + 1] - m[index + 1],race[row + 1][index],race[row + 1][index - 1] - m[index - 1]);
                }else if(index == 2){
                    total += Math.max(race[row + 1][index - 1] - m[index - 1],race[row + 1][index]);
                }
            }
            return total;
        }
        public int getindex(int[] nums, int n){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == n)
                    return i;
            }
            return 0;
        }*/
        public int max(int a, int b, int c){
            if(a < b){
                return b < c ? c : b;
            }else{
                return a < c ? c : a;
            }
        }

}
