package dynamicandgreedyalgorithom.numsofniuniu;

/*https://www.nowcoder.com/practice/edced5e80f3e46efa9c965e7f634c58c
* 题目描述
给出一个字符串S，牛牛想知道这个字符串有多少个子序列等于"niuniu"
子序列可以通过在原串上删除任意个字符(包括0个字符和全部字符)得到。
为了防止答案过大，答案对1e9+7取模 */
public class NumbersOfNiuNiu {
    public static void main(String[] args) {

    }
    //方法1
    public static int solve1 (String s) {
        String str = "*niuniu";//pat="*niuniu"，而不是pat = "niuniu"，这样我令dp[0]=1，即默认“*”已经匹配，那么后面转移时判断c==pat[j]时，可以少一个判断j==0的操作，理论上速度更快些
        int l = s.length();
        int lstr = str.length();
        int[] dp = new int[lstr];
        final int mod = 1000000007;
        dp[0] = 1;
        for(int i = 0; i < l; i++){
            for(int j = 1; j < lstr; j++){
                if(s.charAt(i) == str.charAt(j))
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }
        return dp[lstr - 1] ;
    }
    //方法2,因为“niuniu”字符数较小，可以用switch case 判断
    public static int solve2 (String s2) {
        String str = "niuniu";
        int l2 = s2.length();
        int lstr = str.length();
        int[] dp = new int[lstr];
        final int mod = 1000000007;

        for(int i = 0; i < l2; i++){
            for(int j = 0; j < lstr; j++){
                if(s2.charAt(i) == str.charAt(j)){
                    if(j == 0){
                        dp[j] += 1;
                    }else {
                        dp[j] = (dp[j] + dp[j - 1]) % mod;
                    }
                }
            }
        }
        return dp[lstr - 1] ;
    }
}
