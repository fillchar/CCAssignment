package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by thushy on 2015/9/21.
 */
public class Solution03 {

    private List<Stack<Integer> > stacks = new ArrayList<>();
    int limit = 0x7FFFFFFF, pos = -1;

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void push(int key) {
        if (pos < 0 || stacks.get(pos).size() == limit) {
            pos++;
            stacks.add(new Stack<Integer>());
        }
        stacks.get(pos).push(key);
    }

    public int peek()  throws Exception {
        if (pos < 0) throw new Exception("Empty stack!");
        return stacks.get(pos).peek();
    }

    public int pop() throws Exception {
        if (pos < 0) throw new Exception("Empty stack!");
        int ret = stacks.get(pos).pop();
        if (stacks.get(pos).isEmpty()) stacks.remove(pos--);
        return ret;
    }

}
