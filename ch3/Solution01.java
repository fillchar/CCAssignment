package ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thushy on 2015/9/21.
 */
public class Solution01 {

    int[] top;
    List<Integer> list;

    public Solution01() {
        top = new int[3];
        top[0] = -3; top[1] = -2; top[2] = -1;
        list = new ArrayList<>();
    }

    public void push(int id, int key) {
        top[id] += 3;
        while (top[id] >= list.size()) list.add(0);
        list.set(top[id], key);
    }

    public int pop(int id) throws Exception{
        if (top[id] < 0) throw new Exception("Empty stack!");
        top[id ] -= 3;
        return list.get(top[id] + 3);
    }

    public int peak(int id) throws Exception{
        if (top[id] < 0) throw new Exception("Empty stack");
        return list.get(top[id]);
    }

}
