package array.duplicatenumbers;

import java.util.HashSet;
import java.util.Scanner;

public class DuplicateNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int[] nums = new int[length];
        Scanner array = new Scanner(System.in);
        for(int i = 0; i < length; i++){
            nums[i] = array.nextInt();
        }
        HashSet<Integer> list = new HashSet<Integer>();
        int repeat = -1;
        for(int i = 0; i < length; i++){

             if(!list.add(nums[i])){//返回值：如果Set集合中不包含要添加的对象，则添加对象并返回true；否则返回false。
                repeat = nums[i];
                break;
             }
        }
        System.out.println(repeat);
    }
}
