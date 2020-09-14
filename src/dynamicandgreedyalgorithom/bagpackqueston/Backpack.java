package dynamicandgreedyalgorithom.bagpackqueston;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
/*题目描述
来源 牛客网 地址：https://www.nowcoder.com/practice/6c5c3a9901ec4a90aa140348243da4e8?tpId=110&&tqId=33430&rp=1&ru=/ta/job-code&qru=/ta/job-code/question-ranking
众所周知，牛能和牛可乐经常收到小粉丝们送来的礼物，每个礼物有特定的价值，他俩想要尽可能按照自己所得价值来平均分配所有礼物。

那么问题来了，在最优的情况下，他俩手中得到的礼物价值和的最小差值是多少呢？
p.s 礼物都很珍贵，所以不可以拆开算哦
*/

public class Backpack {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        int l = nextInt();
        int[] giftsVal = new int[l];
        int sum = 0;
        for (int i = 0; i < l; i++) {
            giftsVal[i] = nextInt();
            sum += giftsVal[i];
        }
        int v = sum / 2;//这里用数组的索引表示背包总容量
        int[] dp = new int[v + 1];
        for (int i = 0; i < l; i++) {
            for (int j = v; j >= giftsVal[i]; j--) {//总容量减去单个物品重量表示可以容纳
                dp[j] = Math.max(dp[j], dp[j - giftsVal[i]] + giftsVal[i]);//给dp数组每个索引对应元素赋值，表示每个
                // 背包的容量对应的可容纳物品重量最大值
            }
        }
        System.out.println(Math.abs(sum - 2 * dp[v]));
    }
}
