package ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution03 {

    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<TreeNode> > listOfDepths(TreeNode root) {
        List<List<TreeNode> > ret = new ArrayList<>();
        if (root == null) return ret;
        ret.add(new ArrayList<>(Collections.singletonList(root)));
        while (true) {
            List<TreeNode> list = new ArrayList<>();
            List<TreeNode> last = ret.get(ret.size() - 1);
            for (TreeNode node : last) {
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            if (list.isEmpty()) break;
            ret.add(list);
        }
        return ret;
    }

}
