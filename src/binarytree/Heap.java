package binarytree;

import java.util.Scanner;

class Heap {
    static int N = 100010;
    static int[] h = new int[N];
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= size; i++) h[i] = sc.nextInt();
        //n / 2是从倒数第二层开始down，最后一层默认满足堆条件,复杂度为O(n)
        for (int i = size / 2; i >= 1; i--) down(i);
        for (int i = 1; i <= size; i++) System.out.println(h[i] + " ");;
        for (int i = 0; i < m; i++) {
            System.out.print(h[1] + " ");
            //删除第一个元素，最后一个元素与堆顶元素交换，down出最新的堆顶元素，循环打印输出
            h[1] = h[size--];
            down(1);
        }
    }

    public static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[t] > h[2 * u]) t = u * 2;
        if (u * 2 + 1 <= size && h[t] > h[2 * u + 1]) t = u * 2 + 1;
        if (u != t) {
            swap(t, u);
            down(t);
        }
    }

    public static void swap(int u, int t) {
        int tmp = h[u];
        h[u] = h[t];
        h[t] = tmp;
    }
}
