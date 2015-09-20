package ch3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by thushy on 2015/9/17.
 */
public class Solution02 {

    Stack<Integer> stack = new Stack<>(), min = new Stack<>();

    public void push(int num) {
        stack.push(num);
        min.push(Math.min(min.peek(), num));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

}
