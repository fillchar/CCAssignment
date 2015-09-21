package ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution05 {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    public boolean validateBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) < list.get(i - 1)) return false;
        return true;
    }

}
