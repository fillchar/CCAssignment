package ch4;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution04 {

    private boolean isBalance = true;

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int cntL = dfs(node.left), cntR = dfs(node.right);
        isBalance = isBalance && (Math.abs(cntL - cntR) < 2);
        return Math.max(cntL, cntR) + 1;
    }

    public boolean checkBalanced(TreeNode root) {
        isBalance = true;
        dfs(root);
        return isBalance;
    }


}
