package ch4;

import java.util.Random;

/**
 * Created by floyd on 2015/9/20.
 */
public class Solution11 {

    class TreeNode {

        public int val, size;
        public TreeNode left, right, parent;

        public TreeNode(int val) {
            this.val = val;
            this.size = 1;
            this.left = this.right = this.parent = null;
        }

        public void insert(int key) {
            if (key < val) {
                size++;
                if (left == null) {
                    left = new TreeNode(key);
                    left.parent = this;
                }
                else left.insert(key);
            } else if (key > val) {
                size++;
                if (right == null) right = new TreeNode(key);
                else right.insert(key);
            }
        }

        public TreeNode find(int key) {
            if (val == key) return this;
            if (key < val) {
                if (left == null) return null;
                return left.find(key);
            }
            if (right == null) return null;
            return right.find(key);
        }

        public void remove(TreeNode node) {
            if (parent.left == this) parent.left = node;
            else parent.right = node;
            for (TreeNode n = parent; n != null; n = n.parent) n.updateSize();
        }

        public void delete(int key) {
            this.find(key).delete();
        }

        public void delete() {
            if (left == null) remove(right);
            else if (right == null) remove(left);
            else {
                TreeNode node = left;
                while (node.right != null) node = node.right;
                this.val = node.val;
                node.remove(node.left);
            }
        }

        private void updateSize() {
            size = 1;
            if (left != null) size += left.size;
            if (right != null) size += right.size;
        }

        public TreeNode getKthNode(int k) {
            int cnt = left == null ? 0 : left.size;
            if (cnt == k - 1) return this;
            if (cnt > k - 1) return left.getKthNode(k);
            return right.getKthNode(k - cnt - 1);
        }

    }

    TreeNode root;

    public Solution11() {
        root = new TreeNode(0x7FFFFFFF);
    }

    public void insert(int key) {
        root.insert(key);
    }

    public TreeNode find(int key) {
        return root.find(key);
    }

    public void delete(int key) {
        root.delete(key);
    }

    public TreeNode getRandomNode() {
        int k = new Random().nextInt(root.size - 1) + 1;
        return root.getKthNode(k);
    }

}
