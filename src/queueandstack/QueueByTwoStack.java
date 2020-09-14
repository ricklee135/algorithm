package queueandstack;

import java.util.Stack;

public class QueueByTwoStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node){
        stack1.push(node);
    }
    public int pop() throws Exception {
        if(stack2.isEmpty()){
            while(stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("queue is empty");
        }
        int ret = stack2.pop();
        return ret;
    }
}
