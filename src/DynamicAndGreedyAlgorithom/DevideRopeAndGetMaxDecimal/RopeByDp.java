package DynamicAndGreedyAlgorithom.DevideRopeAndGetMaxDecimal;

import java.util.Scanner;

public class RopeByDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMax(n));
    }
    private static int getMax(int n) {
        /*这里是n <= 3对应绳子乘积的最大值*/
        if(n <= 1)
            return 0;
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 3;
        }
        /*下面数组四项对应 n >= 4的时候，和 n <= 3不同，这里3 和 2 和 1就不用再分了，
        这样对应的值更大
        */
        int [] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for(int i = 4; i <= n; i++){
            max = 0;
            for(int j = 1; j <= i / 2; j++){
                int product = products[i - j] * products[j];
                if(max < product){
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[n];
        return max;
    }
}
