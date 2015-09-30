package ch10;

import ch4.*;

/**
 * Created by floyd on 2015/9/29.
 */
public class Solution05 {

    public int sparseSearch(String[] strings, String target) {
        int l = 0, r = strings.length - 1;
        while (l <= r) {
            System.out.println(l + " " + r);
            int ml = l + r >> 1, mr = ml;
            while (ml >= l && strings[ml].equals("")) ml--;
            while (mr <= r && strings[mr].equals("")) mr++;
            if (ml < l && mr > r) return -1;
            if (ml < l) ml = mr;
            if (mr > r) mr = ml;
            if (strings[ml].equals(target)) return ml;
            if (strings[mr].equals(target)) return mr;
            if (strings[mr].compareTo(target) < 0) l = mr + 1;
            else if (strings[ml].compareTo(target) < 0) l = ml + 1;
            if (strings[ml].compareTo(target) > 0) r = ml - 1;
            else if (strings[mr].compareTo(target) > 0) r = mr - 1;
        }
        return -1;
    }

    private void run() {
        String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(sparseSearch(strings, "dad"));
    }

    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        solution.run();
    }

}
