package array.duplicatednumberswthoutmodifyarray;

import java.util.Scanner;
//采用一边复制一边比较的方式，一次循环，时间复杂度O（n）,由于复制了数组，空间复杂度0（n）.
public class DuplicateNumbersWithoutModifyArray1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int [] nums = new int[length];
        for(int i = 0; i < length; i++){
            nums[i] = scanner.nextInt();
        }
        int [] numsCopy = new int[length];
        for(int j = 0; j < length; j++){
            if(numsCopy[nums[j]] == 0){
                numsCopy[nums[j]] = nums[j];
            }else{
                System.out.println(nums[j]);
                break;
            }
        }
        //System.out.println(Arrays.toString(numsCopy));

//        for(int k = 1; k < length; k++){
//            if(numsCopy[k] == numsCopy[k - 1]){
//                System.out.println(numsCopy[k]);
//                break;
//            }
//        }
    }

}
