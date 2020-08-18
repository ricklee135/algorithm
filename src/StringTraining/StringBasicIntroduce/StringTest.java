package StringTraining.StringBasicIntroduce;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c', 'd'};
        System.out.println(c.toString());//[C@1540e19d

        int[] i = {1, 3, 4 ,5};
        System.out.println(i.toString());//[I@677327b6
        System.out.println(Arrays.toString(c));//[a, b, c, d]
        System.out.println(new String(c));//abcd
    }
}
/*
* 首先我们得了解，java输出用的函数print();是不接受对象直接输出的，只接受字符串或者数字之类的输出。
　　当print检测到输出的是一个对象而不是字符或者数字时，那么它会去调用这个对象类里面的toString 方
* 法，输出结果为[类型@哈希值]。*/