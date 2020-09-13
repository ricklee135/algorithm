import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        if (A * b < a || a * B < b) {//x (A)* b = Y(b) * a ,max X * y 1 - A xuan x 1- b xuan y
            System.out.println(0 + " " + 0);
        }
        long x, y;
        for (x = 1; x < A; x++) {
            y =  x * b / a;
            if (y <= B && a * y == b * x) {
                x++;
            }
        }
        for (y = 1; y < B; y++) {
            x =  y * a / b;
            if (x <= A && a * y == b * x) {
                y++;
            }
        }
        System.out.println(a + " " + b);
    }
}
