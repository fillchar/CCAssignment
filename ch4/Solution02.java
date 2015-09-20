package ch4;

import java.util.List;

/**
 * Created by thushy on 2015/9/17.
 */
public class Solution02 {

    class TreeNode {
        public TreeNode left, right;
        public int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode minimalTree(int[] nums, int l, int r) {
        if (l >= r) return null;
        int m = l + r >> 1;
        TreeNode node = new TreeNode(nums[m]);
        node.left = minimalTree(nums, l, m);
        node.right = minimalTree(nums, m + 1, r);
        return node;
    }

    public TreeNode minimalTree(int[] nums) {
        return minimalTree(nums, 0, nums.length);
    }

}
