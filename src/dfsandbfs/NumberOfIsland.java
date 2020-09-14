package dfsandbfs;

import java.util.Scanner;

public class NumberOfIsland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j, row, col, matrix, visited);
                }
                visited[i][j] = true;
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(int i, int j,int row, int col,int[][] matrix, boolean[][] visited) {
        if (i + 1 < row && !visited[i + 1][j] && matrix[i+ 1][j] == 1){
            visited[i + 1][j] = true;
            dfs(i + 1, j,row,col,matrix,visited);
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && matrix[i- 1][j] == 1){
            visited[i - 1][j] = true;
            dfs(i - 1, j,row,col,matrix,visited);
        }
        if (j + 1 < col && !visited[i][j + 1] && matrix[i][j + 1] == 1){
            visited[i][j + 1] = true;
            dfs(i, j + 1,row,col,matrix,visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && matrix[i][j - 1] == 1){
            visited[i][j - 1] = true;
            dfs(i, j - 1,row,col,matrix,visited);
        }
    }
}
//5 5 1 1 0 0 0 0 1 0 1 1 0 0 0 1 1 0 0 0 0 0 0 0 1 1 1
// outPut 3
//使用递归会栈溢出，所以只有93.57通过