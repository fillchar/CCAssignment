package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution09 {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    void merge(List<Integer> list1, int p1, List<Integer> list2, int p2, List<Integer> gen, List<List<Integer> > dst) {
        if (p1 >= list1.size() && p2 >= list2.size()) {
            dst.add(new ArrayList<>(gen));
            return;
        }
        if (p1 < list1.size()) {
            gen.set(p1 + p2 + 1, list1.get(p1));
            merge(list1, p1 + 1, list2, p2, gen, dst);
        }
        if (p2 < list2.size()) {
            gen.set(p1 + p2 + 1, list2.get(p2));
            merge(list1, p1, list2, p2 + 1, gen, dst);
        }
    }

    public List<List<Integer> > bSTSequences(TreeNode root) {
        if (root == null) return null;
        List<List<Integer> > left = bSTSequences(root.left),
                right = bSTSequences(root.right);
        List<List<Integer> > ret = new ArrayList<>();
        if (left == null) left = new ArrayList<>(Collections.singleton(new ArrayList<>()));
        if (right == null) right = new ArrayList<>(Collections.singleton(new ArrayList<>()));
        List<Integer> list = new ArrayList<>(left.get(0).size() + right.get(0).size() + 1);
        list.add(root.val);
        for (int i = 0; i < left.get(0).size() + right.get(0).size(); i++) list.add(0);
        //System.out.println(root.val + " " + left + " " + right);
        //list.set(0, root.val);
        for (List<Integer> l1 : left)
            for (List<Integer> l2 : right) merge(l1, 0, l2, 0, list, ret);
        return ret;
    }

    private void run() {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);
        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;
        System.out.println(bSTSequences(root));
    }

    public static void main(String[] args) {
        Solution09 solution = new Solution09();
        solution.run();
    }

}
