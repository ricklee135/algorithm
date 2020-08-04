package DuplicatedNumbersWithoutModifyArray;

import java.util.Scanner;
/*
* 以下代码按照二分法的思路，如果输入长度为n的数组，那么函数Count将被调用O(logn)次，每次需要O(n)的时间，
* 因此总的时间时间复杂度为O(n*logn)的时间，空间复杂度为O(1)，需要注意的是，该算法不能保证找出所有的数，
* 例如{2， 3， 5， 3， 2， 6， 7}由于数组中不存在1，其中的两个2会被默认为1，2，无法判断2的重复。
* */
public class DuplicateNumbersWithoutModifyArray2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int nums[] = new int[length];
        for(int i = 0; i < length; i++){
            nums[i] = s.nextInt();
        }
        int start = 1, end = length - 1;
        while(start <= end){
            int mid =((end - start) >> 1) + start;//这里使用位运算，二进制向右移动一位，相当于原式结果/2，
            int count = Count(nums, length, start, mid);
            if(end == start){
                if(count > 1){
                    System.out.println(start);
                    break;
                }else {
                    break;
                }
            }
            if(count > mid - start + 1){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
    }

    private static int Count(int[] nums, int length, int start, int end) {
        int count = 0;
        for(int i = 0;i < length; i++ ){
            if(nums[i] >= start && nums[i] <= end ){
                count++;
            }
        }
        return count;
    }
}
