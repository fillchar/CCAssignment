package ch4;

import sun.reflect.generics.tree.Tree;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution10 {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return check(node1.left, node2.left) && check(node1.right, node2.right);
    }

    public boolean checkSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true; // Suppose that an empty tree is a subtree of any tree.
        if (root1 == null) return false;
        if (check(root1, root2)) return true;
        return checkSubtree(root1.left, root2) || checkSubtree(root1.right, root2);
    }

}
