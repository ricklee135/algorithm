package BitOpratioon;

import java.util.Arrays;
import java.util.Scanner;

public class AppealTimeLargerThanHalfOfTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] nums = new int[l];
        for (int i = 0; i < l; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(MoreThanHalfNum_Solution(nums));
        System.out.println(MoreThanHalfNum_Solution2(nums));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        int l = array.length;
        int max = Integer.MIN_VALUE;
        int record = 0;
        for (int i = 0; i < l; i++) {
            int count = 0;

            for (int j = 0; j < l; j++) {
                if (array[j] == array[i])
                    count++;

            }
            max = Math.max(count, max);
            if (max > l / 2) {
                record = array[i];
                break;
            }
        }
        return record;
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {
        int l2 = array.length;
        Arrays.sort(array);
        int mid = array[l2 / 2];
        int count = 0;
        for (int i = 0; i < l2; i++) {
            if (mid == array[i]) {
                count++;
            }
        }
        if (count > l2 / 2) {
            return mid;
        } else {
            return 0;
        }
    }
}
//思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
//
//
//在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它
// 与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，
// 并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
//9 2 2 3 2 2 2 5 4 2