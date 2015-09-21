package ch3;

import java.util.Stack;

/**
 * Created by thushy on 2015/9/21.
 */
public class Solution05 {

    private Stack<Integer> tmp = new Stack<>();

    public void sort(Stack<Integer> stack, int pos) {
        int max = 0x80000000;
        boolean flag = false;
        while (stack.size() > pos) {
            if (max < stack.peek()) {
                if (!flag) flag = true;
                else tmp.push(max);
                max = stack.pop();
            }
            else tmp.push(stack.pop());
        }
        stack.push(max);
        while (!tmp.isEmpty()) stack.push(tmp.pop());
    }

    public void sortStack(Stack<Integer> stack) {
        for (int i = 0; i < stack.size(); i++) sort(stack, i);
    }

    public void run() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) stack.push(i);
        //System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        solution.run();
    }

}
