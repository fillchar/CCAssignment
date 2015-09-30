package ch10;

import java.util.*;

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

    // sort
    public void groupAnagramsSort(String[] strings) {
        Arrays.sort(strings, comparator);
    }

    // hashmap
    public void groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            byte[] bytes = str.getBytes();
            Arrays.sort(bytes);
            String st = new String(bytes);
            List<String> list = map.get(st);
            if (list == null) {
                list = new ArrayList<>();
                map.put(st, list);
            }
            list.add(str);
        }
        int pos = 0;
        for (List<String> l : map.values()) {
            for (String st : l) strings[pos++] = st;
        }
    }

    public void run() {
        String[] strings = new String[3];
        strings[0] = "ab";
        strings[1] = "aa";
        strings[2] = "ba";
        groupAnagrams(strings);
        System.out.println(strings[0] + " " + strings[1] + " " + strings[2]);
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        solution.run();
    }

}
