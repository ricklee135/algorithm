package Exam.Haikang;

import java.util.Scanner;

//寻找一个数组中子数组和的最小值
//思路，整体取负数，判断最大子序列
public class Solution {
    public static int greatMIn(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int greatMin = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sum = sum <= 0 ? nums[i] : sum + nums[i];
            greatMin = Math.max(sum,greatMin);
        }
        return -greatMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(greatMIn(nums));
    }
}
