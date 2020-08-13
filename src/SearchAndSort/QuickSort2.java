package SearchAndSort;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) throws Exception {
        int[] nums = {2, 5, 6, 3, 32, 4, 61, 9, 31, 10};
        int length = nums.length;
        quickSort(nums, length, 0, length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int length, int start, int end) throws Exception {
        if (start == end) {
            return;
        }
        int index = partition(nums, length, start, end);
        if (index > start) {
            quickSort(nums, length, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, length, index + 1, end);
        }
    }

    private static int partition(int[] nums, int length, int start, int end) throws Exception {
        if (length <= 0 || start < 0 || end >= length) {
            throw new Exception("invalid parameters");
        }
        int index = (int) (Math.random() * (end - start + 1));
        swap(nums, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (nums[index] < nums[end]) {
                small++;
                if (small != index)
                    swap(nums, index, small);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }
    //java传递是引用的拷贝，既不是引用本身，更不是对象。所以在改变数组时候需要在数组内部完成交换，而不能用普通的值传递
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

}
