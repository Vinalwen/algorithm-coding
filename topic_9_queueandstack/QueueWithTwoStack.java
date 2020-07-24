package topic_9_queueandstack;

import java.util.Stack;

/**
 * @author wenyao
 * @create 2020-07-21 10:43
 * ^-^ Fighting!
 */
public class QueueWithTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){
        //只有当stack2为空时，才把stack1中的压进stack2
        if(stack2.isEmpty()){
            if(stack1.isEmpty())
                throw new RuntimeException("The stack1 is empty");
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
