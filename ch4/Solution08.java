package ch4;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution08 {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    TreeNode ans = null;

    int findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || ans != null) return 0;
        int ret = 0;
        if (node == q) ret = 1;
        if (node == p) ret = 2;
        ret = ret | findLCA(node.left, p, q);
        if (ans != null) return 0;
        ret = ret | findLCA(node.right, p, q);
        if (ans != null) return 0;
        if (ret == 3) ans = node;
        return ret;
    }

    public TreeNode firstCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        findLCA(root, p, q);
        return ans;
    }

}
