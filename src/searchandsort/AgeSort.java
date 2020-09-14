package searchandsort;

import java.util.Arrays;
import java.util.Random;

//在O(n)复杂度对一个公司员工的年龄排序
public class AgeSort {
    public static void main(String[] args) {
        int[] ages = new int[50000];
        Random age = new Random();
        for (int i = 0; i < 50000; i++) {
//将每个人的年龄赋值为一个0-99的随机数
            ages[i] = age.nextInt(100);
        }
        System.out.println(Arrays.toString(ages));
        System.out.println(Arrays.toString(sortAges(ages)));
    }

    private static int[] sortAges(int[] ages) {
        int[] agesRange = new int[100];
        for (int j = 0; j < 100; j++) {
            agesRange[j] = 0;
        }
        for (int i = 0; i < ages.length; i++) {
            //if(ages[i] < 0 ||ages[i] > 100){
            //   return null;
            //}//
            //统计每个年龄数的人数
            agesRange[ages[i]]++;
        }
        int index = 0;
        for (int k = 0; k < 100; k++) {
            //以数组中储存的人数循环，将数组索引(年龄)重新赋值给ages数组，完成排序
            for (int j = 0; j < agesRange[k]; j++) {
                ages[index] = k;
                index++;
            }
        }
        return ages;
    }
}
