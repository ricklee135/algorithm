import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        char[] c = {'a', 'b', 'c', 'd'};
        System.out.println(c.toString());//[C@1540e19d

        int[] i = {1, 3, 4 ,5};
        System.out.println(i.toString());//[I@677327b6
        System.out.println(Arrays.toString(c));//[a, b, c, d]
        System.out.println(new String(c));//abcd
    }
}
