package array;

import java.util.ArrayList;
import java.util.Scanner;

public class OutputArrayClockwise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][]  matrix = new int[row][col];
        for(int i = 0 ; i < row;i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    public static ArrayList clockwiseOutput(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int cycle = ((row < col ? row : col) - 1) / 2 + 1;//圈数，奇偶不知道到的情况找中点,注意这里的括号
        for(int i = 0; i < cycle; i++){
            for(int j = i; j < col - i;j++){
                list.add(matrix[i][j]);
            }
            for(int k = i + 1;k < row - i;k++){
                list.add(matrix[k][col - 1 - i]);
            }
            //判断是否会重复打印从右向左每行数据
            for(int m = col - i - 2;m >= i && row - i - 1 != i;m --){
                list.add(matrix[row - i - 1][m]);
            }
            //判断是否会重复打印，从下往上的每行数据
            for(int n = row - i- 2; n > i&& col- i - 1 != i; n--){
                list.add(matrix[n][i]);
            }
        }
        return list;
    }
}
