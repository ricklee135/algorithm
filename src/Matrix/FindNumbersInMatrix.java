package Matrix;

import java.util.Scanner;

public class FindNumbersInMatrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int columns = s.nextInt();
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = s.nextInt();    
            }
        }
        int targetNumber = s.nextInt();
        System.out.println(Find(matrix, rows, columns, targetNumber));
    }

    private static boolean Find(int[][] matrix, int rows, int columns, int targetNumber) {
        if(matrix == null && matrix.length == 0 && matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while(row < rows && column >= 0){
            int temp = matrix[row][column];

            if(targetNumber == temp){
                return true;//temp = matrix[row][column--];
            }else if(targetNumber > temp){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }
}/*to find number 7,
1  2← 8← 9
   ↓
2  4  9  12
   ↓
4  7  10 13

6  8  11 15
*/