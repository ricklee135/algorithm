package SearchAndSort;


public class BlanksRobotCanReach {
    private final static int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//右， 左， 下， 上

    public static void main(String[] args) {

        int threshold = 5;
        int[][] matrix = new int[10][10];
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println(hasPath(matrix, rows, cols, threshold));
    }

    private static int hasPath(int[][] matrix, int row, int col, int threshold) {
        if (row < 0 || col < 0)
            return 0;
        boolean[][] visited = new boolean[row][col];
        int count = backTracking(matrix, threshold, visited, 0, 0);
        return count;
    }

    private static int backTracking(int[][] matrix, int threshold, boolean[][] visited, int row, int col) {
        int total = getDigitalTotal(row, col);
        int count = 0;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && total <= threshold && !visited[row][col]) {
            visited[row][col] = true;
            count = 1;
            for (int[] n : next) {
                count += backTracking(matrix, threshold, visited, row + n[0], col + n[1]);
            }
//            count = 1 + backTracking(matrix, threshold, visited, row + 1, col) +
//            backTracking(matrix, threshold, visited, row - 1, col) +
//            backTracking(matrix, threshold, visited, row, col + 1) +
//            backTracking(matrix, threshold, visited, row, col - 1) ;
        }
        return count;
    }

    private static int getDigitalTotal(int row, int col) {
        int total = 0;
        while (row > 0) {
            total += row % 10;
            row = row / 10;
        }
        while (col > 0) {
            total += col % 10;
            col = col / 10;
        }
        return total;
    }
}
