##1.利用栈后进先出的特性，将链表中的元素压入栈中再将数据弹出，从而实现链表的翻转
代码如下：
    public ArrayList printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        Stack stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
##2.调用ArrayList中add的一个函数，ArrayList.add(index, value)来实现
代码如下：
    public class Solution {
        public ArrayList printListFromTailToHead(ListNode listNode) {
            ArrayList list = new ArrayList();
            while (listNode != null) {
                list.add(0, listNode.val);
                listNode = listNode.next;
            }
            return list;
        }
    }
##3.通过递归调用的方法实现，利用系统的"栈"来实现功能
    import java.util.*;
    public class Solution {
        ArrayList<Integer> list = new ArrayList();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null){
                printListFromTailToHead(listNode.next);
                list.add(listNode.val);
            }
            return list;
        }
    }
注意：当链表非常长的时候，就会导致函数调用的层级很深，有可能导致调用栈溢出。      
    