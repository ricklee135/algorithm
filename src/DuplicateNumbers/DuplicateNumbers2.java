package DuplicateNumbers;

import java.util.Scanner;

public class DuplicateNumbers2 {
    public static void main(String[] args) {
        Scanner s1;
        s1 = new Scanner(System.in);
        int length = s1.nextInt();
        int[] nums = new int[length];
        Scanner array = new Scanner(System.in);
        for(int i = 0; i < length; i++){
            nums[i] = array.nextInt();
        }
        for(int i = 0; i < length; i++){
           while (i != nums[i]){
               if(nums[nums[i]] != nums[i]){
                   int t;
                   t = nums[i];
                   nums[i] = nums[t];
                   nums[t] = t;
               }else {
                   System.out.println(nums[i]);
                   break;
               }
           }
        }
    }
}//该方法的空间复杂度为O（1）

