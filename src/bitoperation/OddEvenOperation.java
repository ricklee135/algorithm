package bitoperation;

import java.util.Scanner;

public class OddEvenOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] nums = new int[l];
        for(int i = 0; i < l;i++){
            nums[i] = sc.nextInt();
        }
        //copy method
        int[] odd = new int[l];
        int[] even = new int[l];
        int countO = 0,countE = 0;
        for(int i = 0;i < l; i++){
            if((nums[i] & 1) == 1){
                odd[countO] = nums[i];
                countO++;
            }else{
                even[countE] = nums[i];
                countE++;
            }
        }
        for(int j = 0;j < l; j++){
            if(j < countO){
                nums[j] = odd[j];
            }else {
                nums[j] = even[j - countO];
            }

        }
        for(int i = 0; i < l;i++){
            System.out.print(nums[i]);
        }
        System.out.println();
        //in-place method
        int k = 0;
        for(int i = 0; i < l; i++){
            if((nums[i] & 1) == 1){
                int temp = nums[i];
                for(int j = i - 1; j >= k; j--){
                    nums[j + 1] = nums[j];
                }
                nums[k] = temp;
                k++;
            }
        }
        for(int i = 0; i < l;i++){
            System.out.print(nums[i]);
        }
    }
}
