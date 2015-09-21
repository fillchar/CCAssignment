package ch4;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution06 {

    TreeNode successor = null;
    TreeNode last = null;

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private void dfs(TreeNode node, TreeNode tar) {
        if (node == null) return;
        dfs(node.left, tar);
        if (last == tar) successor = node;
        last = node;
        dfs(node.right, tar);
    }

    public TreeNode successor(TreeNode root, TreeNode tar) {
        dfs(root, tar);
        return successor;
    }

}
