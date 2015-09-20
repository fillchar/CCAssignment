package ch3;

import java.util.Stack;

/**
 * Created by thushy on 2015/9/17.
 */
public class Solution04 {

    private Stack<Integer> queue = new Stack<>(), tmp = new Stack<>();

    public void push(int num) {
        while (!queue.isEmpty())
            tmp.push(queue.pop());
        queue.push(num);
        while (!tmp.isEmpty())
            queue.push(tmp.pop());
    }

    public int peek() {
        return queue.peek();
    }

    public void pop() {
        queue.pop();
    }

}
