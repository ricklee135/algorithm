package exam.hakang;

import java.util.Scanner;

//寻找一个数组中子数组和的最小值
//思路，整体取负数，判断最大子序列
public class Solution {
    public static int greatMIn1(int[] nums) {
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

    private static int greatMIn2(int[] nums) {
        int sum, result;
        sum = result = nums[0];
        for(int i = 0; i < nums.length; i++){
            //wrong method
            /*if(sum < 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            if(sum < result){
                result = sum;
            }*/
            sum = Math.min(sum + nums[i] , nums[i]);
            result = Math.min(sum,result);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(greatMIn1(nums));
        System.out.println(greatMIn2(nums));
    }
}
