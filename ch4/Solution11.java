package ch4;

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
            if (key < val) return left.find(key);
            return right.find(key);
        }

        public void delete(int key) {
            if (key == val) {
                if (left == null )
                return;
            }
            if (key < val) {
                size--;
                left.delete(key);
            } else if (key > val) {
                size--;
                right.delete(key);
            }
        }
    }



}
