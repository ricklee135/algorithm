import java.util.ArrayList;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        char[] c = {'a', 'b', 'c', 'd'};
        System.out.println(c.toString());//[C@1540e19d
        ArrayList<Integer> list  = new ArrayList<>();
        int[] i = {1, 3, 4 ,5};
        //ArrayList<Integer> iList = new ArrayList<Integer>(Arrays.asList(i));//将数组转换为Arraylist
        //不能使用该方法应为基本类型不一样，String类型可以使用。
        System.out.println(i.toString());//[I@677327b6
        System.out.println(Arrays.toString(c));//[a, b, c, d]
        System.out.println(new String(c));//abcd
        System.out.println(Arrays.toString(Arrays.copyOfRange(i, 1, 2)));
        //
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        System.out.println(queue.size());
        int[] n = {12, 3, 6,9,5};
        Arrays.sort(n);



    }
}
