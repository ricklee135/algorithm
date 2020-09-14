package nowcodercompition.LoadGoods;

import java.util.Arrays;
import java.util.Scanner;

public class LoadGoods {

    private static boolean dfs(int[] goods, int[] boxLoaded, int x, int w, int u) {
        if (u > goods.length - 1) return true;

        for (int i = 0; i <= u && i < x; i++) {
            if (boxLoaded[i] + goods[goods.length - u - 1] <= w) {
                boxLoaded[i] += goods[goods.length - u - 1];
                if (dfs(goods, boxLoaded, x, w, u + 1)) return true;
                boxLoaded[i] -= goods[goods.length - u - 1];
            }
        }
        return false;
        //this is my method ,greedy algorithm, can't make it.
        /*Arrays.sort(goods);
        int length = goods.length;

        int left = 0, right = length - 1;
        for (int i = 0; i < length; i++) {
            if (goods[i] > w)
                return "No";
        }
        while (left < right) {
            int temp = w;
            while (goods[right] <= temp && left < right) {
                temp -= goods[right];
                right--;
                while (goods[left] <= temp && left < right) {
                    temp -= goods[left];
                    left++;
                }
            }
            x--;
        }
        if (x >= 0)
            return "Yes";
        return "No";*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int w = sc.nextInt();
            int[] goods = new int[n];
            int[] boxLoaded = new int[x];
            for (int j = 0; j < n; j++) {
                goods[j] = sc.nextInt();
            }
            Arrays.sort(goods);
            System.out.println((dfs(goods, boxLoaded, x, w, 0) ? "Yes" : "No"));
        }

    }
}
