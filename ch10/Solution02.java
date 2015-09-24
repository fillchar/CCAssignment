package ch10;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution02 {

    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            byte[] b1 = o1.getBytes(), b2 = o2.getBytes();
            Arrays.sort(b1);
            Arrays.sort(b2);
            return new String(b1).compareTo(new String(b2));
        }
    };

    public void groupAnagrams(String[] strings) {
        Arrays.sort(strings, comparator);
    }

}
