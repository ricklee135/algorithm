package SearchAndSort;
//作者：CyC2018
//链接：https://www.nowcoder.com/discuss/198840?type=1
//来源：牛客网
//
// 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序
// 的数组。新的旋转数组的数组元素是原数组的一半，从而将问题规模减少了一半，
// 这种折半性质的算法的时间复杂度为 O(logN)（为了方便，这里将 log<sub>2</sub>N 写为 logN）。
// 非递减数组的第一个元素一定小于等于最后一个元素。
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {11, 15, 20, 0, 1, 3, 6, 8, 9};
        System.out.println(minNumberInRotateArray(nums));
    }
//当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    private static int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }
}
