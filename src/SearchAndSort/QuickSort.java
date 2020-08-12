package SearchAndSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random ran = new Random();
        //1.还可以通过Math.random()生成[0,1)double类型的数如果要生成[0,n]的随机整数的话，只需要Math.random()乘以n+1
        //2.ThreadLocalRandom.current().nextInt(); 生成随机数。random.nextInt(m)表示生成[0,m-1]之间的随机数，
        //也就是说random.nextInt(m+1)，将生成[0,m]之间的随机整数。
        for (int i = 0; i < 10; i++) {
            nums[i] = ran.nextInt(11);
        }
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    private static void quickSort(int[] nums, int left, int right) {
        if (nums.length == 0 || left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int index = nums[left];
        while (i < j) {
            // 注意，由于这里采用了左边为基准值，假如遇到一个有序数列
            // 1， 3， 5， 7， 9
            // 而且在这里，如果先从左边开始寻找的话，一直往右寻找大于1的数，
            // 直到i变成4还没有找到，i < j 条件不满足循环停止了；
            // 但是后面的语句就会把9赋值在1上，
            // 如果先从右边寻找，一直往左寻找小于1的数，直到j变成0还
            // 没有找到然后停止，此时i和j都是0，所以就是把自身交换一下并不影响顺序。
            //
            while (nums[j] >= index && i < j) {
                j--;
            }
            while (nums[i] <= index && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        //这时候i和j一定是相等的，i和j定位到了一个没有参与比较的数，这时候把它和基准值交换，使得基准值两边一边比它小
        //一边比他大，nums[left]相当于基准值，nums[i]在本轮中未参加排序，所以交换
        nums[left] = nums[i];
        nums[i] = index;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }
}
