package exam.huawei;

import java.util.Scanner;
//思想：使用二分法不断逼近目标，不断对二分法的值进行校验，找出每组和小于的最大的值，然后根据索引输出。
public class MaxDivided {
    static int m, k, ans;
    static int[] nums = new int[505];

    private static boolean check(int mid) {
        int now = 0, t = 0;
        for (int i = 0; i < m; i++) {
            if (now >= mid) {
                t++;
                now = 0;
                i--;
            } else {
                now += nums[i];
            }
        }
        if (now >= mid) {
            t++;
        }
        if (t >= k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            ans += nums[i];
        }
        if (k == 1) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i] + " ");
            }
        }
        int l = 0, r = ans;
        while (l < r) {
            int mid = (r + l) / 2;
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int d = l;
        int now = 0;
        int[] index = new int[505]; //用于记录索引
        int num = 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            now += nums[i];

            if (now >= d) {
                index[count] = i;
                now = 0;
                num++;
                count++;
            }
            if (num >= k) {
                break;
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            System.out.print(nums[i] + " ");
            if (i == index[cnt]) {
                cnt++;
                System.out.print("/ ");
            }
        }
    }
}
//6 3 1 2 3 2 5 4 输出 1 2 3 / 2 5 / 4
//输入
//9 3 100 200 300 400 500 600 700 800 900
//输出
//100 200 300 400 500 / 600 700 / 800 900