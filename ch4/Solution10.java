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
        public TreeNode rotate() {
            TreeNode node = left;
            left = node.right;
            node.right = this;
            return node;
        }
    }

}
