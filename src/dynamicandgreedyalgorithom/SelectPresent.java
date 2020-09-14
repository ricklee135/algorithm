package dynamicandgreedyalgorithom;

import java.util.Scanner;

public class SelectPresent {
    //this is my method
  /*  private static int[][] next = {{1, 0}, {0, 1}, {1, 1}};
    static int min = 0;

    private static int selectPresent(int[][] presentVol, int row, int col) {
        if (row == 0 && col == 0) {
            min = presentVol[0][0];
        }
        while (row < presentVol.length && col < presentVol[0].length) {
            for (int[] n : next) {
                selectPresent(presentVol, row + n[0], col + n[1]);
                min += presentVol[row][col];
                min = Math.min(min, min += presentVol[row][col]);
            }

        }
}
        return min;*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] presentVol = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                presentVol[i][j] = sc.nextInt();
            }
        }
        System.out.println(selectPresent(presentVol));
    }

    private static int selectPresent(int[][] presentVol) {
        int[][] dp = new int[310][310];
        int n = presentVol.length;
        int m = presentVol[0].length;
        dp[0][0] = presentVol[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + presentVol[0][i];
        }
        for (int j = 1; j < n; j++) {
            dp[j][0] = dp[j - 1][0] + presentVol[j][0];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[j][i] = presentVol[j][i] +
                min(dp[j - 1][i - 1], dp[j - 1][i], dp[j][i - 1]);

            }
        }
        return dp[n - 1][m - 1];
    }

    private static int min(int a, int b, int c) {
        if (a < b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }
}
