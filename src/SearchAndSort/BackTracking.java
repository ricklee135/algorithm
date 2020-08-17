package SearchAndSort;

public class BackTracking {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        char[][] str = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        int row = str.length;
        int col = str[0].length;
        char[] s = {'b', 'f', 's', 'e'};
        System.out.println(hasPath(str, row, col, s));
    }

    private static boolean hasPath(char[][] str, int row, int col, char[] s) {
        if (row < 1 && col < 1) {
            return false;
        }
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

    private static String printPath(int i, int j) {
        StringBuffer s = new StringBuffer();
        s.append(i);
        s.append(",");
        s.append(j);
        return s.toString();
    }

    private static boolean backTracking(char[][] str, char[] s, boolean[][] visited, int pathLength, int r, int c) {
        if (pathLength == s.length)
            return true;
        if (r < 0 && r >= str.length && c < 0 && c >= str[0].length && visited[r][c] && str[r][c] != s[pathLength]) {
            return false;
        }
        visited[r][c] = true;
        for (int[] n : next) {
            if (backTracking(str, s, visited, pathLength + 1, r + n[0], c + n[1]))
                //System.out.println(printPath(r,c));
                return true;
        }
        visited[r][c] = false;
        return false;
    }
}
