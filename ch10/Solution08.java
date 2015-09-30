package ch10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by floyd on 2015/9/29.
 */
public class Solution08 {

    // suppose input use no memory, or we should read the number in file.
    // use less than 10KB extra memory.
    public List<Integer> findDuplicates(int[] nums) {
        int[] cover = new int[1000];
        List<Integer> ret = new ArrayList<>();
        for (int i : nums) {
            int pos = (i - 1) / 32, bias = (i - 1) % 32;
            if ((cover[pos] & (1 << bias)) != 0) ret.add(i);
            else cover[pos] += 1 << bias;
        }
        return ret;
    }
}
