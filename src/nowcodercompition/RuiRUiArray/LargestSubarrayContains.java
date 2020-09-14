package nowcodercompition.RuiRUiArray;

import java.io.*;
import java.io.StreamTokenizer;
/*
question describe：
* 链接：https://ac.nowcoder.com/acm/contest/6944/A
来源：牛客网
小睿睿给了你一个长度为n的数列，他想问你该数列中满足条件（区间内存在某个数是区间内所有数的公因数）的最长区间有多少个 */

public class LargestSubarrayContains {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static int nextInt() throws IOException{//快速输入
        in.nextToken();
        return (int)in.nval;
    }
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(System.in);用Scanner来输入数据由于超时出现了部分用例无法通过，见Md文件。
        int n = nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nextInt();
        }
        System.out.println(getSubArrays(nums));
    }
    //method1
    private static int getSubArrays(int[] nums) {
        int l = nums.length,max = 0, count = 0;
        int[] dp = new int[l];//创建一个数组，存储每个对应索引所在位置的右边数字公因数序列长度(包括i所在位置)
        for (int i = 0, j; i < l; i = j) {
            j = i + 1;
            while (j < l && nums[j] % nums[i] == 0) {
                j++;
            }
            dp[i] = j - i;
        }
        for (int j = l - 1, i; j >= 0; j = i) {
            i = j - 1;
            while (i >= 0 && nums[i] % nums[j] == 0){
                i--;
            }
            dp[j] += j - i - 1;//由于前面右遍历的时候已经计算了索引处的元素，故多减去1；
        }
        for(int i = 0; i < l; i++){
            if(max < dp[i]){
                max = dp[i];
                count = 1;
            } else if(max == dp[i]){
                count++;
            }
        }
        return count;
    }
}
