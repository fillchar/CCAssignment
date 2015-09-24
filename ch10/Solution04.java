package ch10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution04 {

    class Listy extends ArrayList<Integer> {

        public int size() {
            return -1;
        }

        public Integer elementAt(int i) {
            if (i < super.size()) return get(i);
            return -1;
        }
    }

    public int sortedSearchNoSize(Listy list, int target) {
        int size = 1;
        while (list.get(size - 1) >= 0) size = size << 1;
        int l = 0, r = size - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (list.get(m) < 0 || list.get(m) <= target) r = m;
            else l = m + 1;
        }
        if (l > r || list.get(l) != target) return -1;
        return l;
    }

}
