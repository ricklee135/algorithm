public class Test {
    public static void main(String[] args) {
        System.out.println(min(1, -3, 5
        ));
    }

    private static int min(int a, int b, int c) {
        if (a < b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }
}
