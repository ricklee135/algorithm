package Exam.xiaomi;

import java.util.Scanner;

public class FindWord {
    public static class BackTracking {
        private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        //  ['A','B','C','E'],
        //
        //  ['S','F','C','S'],
        //
        //  ['A','D','E','E']
        public static void main(String[] args) {
            char[][] str = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
            int row = str.length;
            int col = str[0].length;
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            char[] s1 = s.toCharArray();
            System.out.println(hasPath(str, row, col, s1));
        }

        private static boolean hasPath(char[][] str, int row, int col, char[] s) {
            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (backTracking(str, s, visited, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }
        private static boolean backTracking(char[][] str, char[] s, boolean[][] visited, int pathLength, int r, int c) {
            if (pathLength == s.length)
                return true;
            if (r < 0 || r >= str.length || c < 0 || c >= str[0].length || visited[r][c] || str[r][c] != s[pathLength]) {
                return false;
            }
            visited[r][c] = true;
            for (int[] n : next) {
                if (backTracking(str, s, visited, pathLength + 1, r + n[0], c + n[1]))
                    return true;
            }
            visited[r][c] = false;
            return false;
        }
    }

}
