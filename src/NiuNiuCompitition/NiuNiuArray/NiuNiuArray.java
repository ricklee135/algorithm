package NiuNiuCompitition.NiuNiuArray;

import java.util.Arrays;
import java.util.Scanner;

public class NiuNiuArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(IncreaseSubArray(nums));
    }

    private static int IncreaseSubArray(int[] nums) {
        int n = nums.length, max = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        r[n - 1] = 1;
        //遍历该数组，找出i位置前面比i小的元素的个数(由于默认值为1，包括i索引位置的元素)
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1])
                l[i] = l[i - 1] + 1;
            else l[i] = 1;
        }
        //遍历该数组，找出i位置后面比i大的元素的个数(由于默认值为1，包括i索引位置的元素)
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1])
                r[i] = r[i + 1] + 1;
            else r[i] = 1;
        }
        for(int i = 1; i < n - 1; i++){
            int sum = 0;
            if(nums[i - 1] < nums[i + 1]){
                sum = l[i - 1] + r[i + 1] + 1;
            }
            if(max < sum)
                max = sum;
        }
        return max;
    }
}
