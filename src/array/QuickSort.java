package array;

import java.util.Scanner;

public class QuickSort {
    //思路先寻找分界点（随机选取一个值）双指针在左右两端往中间走，与选取值比较（顺序排序左小右大），记录索引，交换位置，直至相遇，记录相遇位置
    //这样中间位置的元素左边的数都小于它，右边的数都大于它，利用相遇位置索引将数组分治，递归求（0 - 相遇index）和（相遇index - r）
    //确定分界点，调整区间，递归处理左右两段。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for(int i = 0; i < length; i++){
            nums[i] = sc.nextInt();
        }
        int l = 0, r = length - 1;
        quickSort(nums,0,length - 1);
        for(int i = 0; i < length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    private static void quickSort(int[] nums, int l, int r) {
        if(l >= r){
            return;
        }
        int x = nums[(l + r) >> 1];//分别选取i j的时候，不能选择l r作为分界点，容易导致死循环 例如 1 2 选则1 作为分界点
        int i = l - 1, j = r + 1;
        while (i < j){
            do {
                i++;
            }while (nums[i] < x);
            do {
                j--;
            }while (nums[j] > x);
            if(i < j)
                swap(nums,i,j);
        }
        quickSort(nums,l,j);
        quickSort(nums,j + 1, r);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
