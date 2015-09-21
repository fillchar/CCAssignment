package ch4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution12 {

    Map<Integer, Integer> cnt = new HashMap<>();
    int ret = 0;

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private void dfs(TreeNode node, int sum, int tar) {
        if (node == null) return;
        int s = sum + node.val;
        // System.out.println(node.val + " " + s + " " + cnt);
        if (cnt.containsKey(s - tar))
            ret += cnt.get(s - tar);
        if (cnt.containsKey(s)) cnt.put(s, cnt.get(s) + 1);
        else cnt.put(s, 1);
        dfs(node.left, s, tar);
        dfs(node.right, s, tar);
        int t = cnt.get(s) - 1;
        if (t == 0) cnt.remove(s);
        else cnt.put(s, t);
    }

    public int pathWithSum(TreeNode root, int tar) {
        dfs(root, 0, tar);
        return ret;
    }

    private void run() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        System.out.println(pathWithSum(root, 8));
    }

    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        solution.run();
    }

}
