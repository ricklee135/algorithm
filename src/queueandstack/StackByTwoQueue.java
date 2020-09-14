package queueandstack;

import java.util.LinkedList;
import java.util.Queue;

public class StackByTwoQueue {
    //队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
    //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
    Queue<Integer> queue1 = new LinkedList<>();
    //在将双端队列用作队列时，将得到 FIFO（先进先出）行为。将元素添加到双端队列的末尾，
    // 从双端队列的开头移除元素。从Queue 接口继承的方法完全等效于 Deque 方法.
    //Deque<Integer> queue2 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        //添加元素，add()和remove()方法在失败的时候会抛出异常(不推荐)
        queue1.offer(node);
    }

    public int pop() {
        while (queue1.size() > 1) {
            ////返回第一个元素，并在队列中删除
            queue2.offer(queue1.poll());
        }

        int ret = queue1.poll();
        //queue1与queue2交换，始终保持queue1中剩下的元素是最后压入的元素，首先被弹出
        queue1 = queue2;
        return ret;
    }
}
