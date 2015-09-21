package ch4;

import java.util.*;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution07 {

    // Assume that each project has a distinct int label;

    public List<Integer> buildOrder(Set<Integer> projects, Map<Integer, List<Integer> > dependencies) throws Exception{
        Map<Integer, List<Integer> > unlock = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : projects) {
            cnt.put(i, 0);
            unlock.put(i, new ArrayList<>());
        }
        for (Integer i : dependencies.keySet()) {
            cnt.put(i, dependencies.get(i).size());
            for (Integer j : dependencies.get(i))
                unlock.get(j).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : projects)
            if (cnt.get(i) == 0) list.add(i);
        for (int pos = 0; pos < list.size(); pos++) {
            for (int j : unlock.get(list.get(pos))) {
                int c = cnt.get(j) - 1;
                cnt.put(j, c);
                if (c == 0) list.add(j);
            }
        }
        if (list.size() != projects.size()) throw new Exception("no valid build order");
        return list;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(i);
        Map<Integer, List<Integer> > dependencies = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            List<Integer> list = dependencies.get(a);
            if (list == null) list = new ArrayList<>();
            list.add(b);
            dependencies.put(a, list);
        }
        try {
            System.out.println(buildOrder(set, dependencies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution07 solution = new Solution07();
        solution.run();
    }

}
