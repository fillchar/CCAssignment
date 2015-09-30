package ch10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by thushy on 2015/9/30.
 */
public class Solution10 {

    TreeNode root = new TreeNode(Integer.MAX_VALUE);

    // Using binary search tree, it's just a demo, using balanced binary search tree is better.
    class TreeNode {

        public int val, size, cnt;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.size = this.cnt = 1;
            this.left = this.right = null;
        }

        public void insert(int key) {
            size++;
            if (key < val) {
                if (left == null) left = new TreeNode(key);
                else left.insert(key);
            } else if (key > val) {
                if (right == null) right = new TreeNode(key);
                else right.insert(key);
            } else cnt++;
        }

    }

    public void track(int x) {
        root.insert(x);
    }

    private int getSize(TreeNode node) {
        if (node == null) return 0;
        return node.size;
    }

    public int getRankOfNumber(int x) {
        TreeNode node = root;
        int cnt = 0;
        while (node != null) {
            if (node.val == x)  return  cnt + node.cnt - 1 + getSize(node.left);
            if (node.val > x) node = node.left;
            else {
                cnt += node.cnt + getSize(node.left);
                node = node.right;
            }
        }
        return cnt;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        for (int i = 0; i < n; i++)
            track(scanner.nextInt());
        for (int i = 0; i < m; i++)
            System.out.println(getRankOfNumber(scanner.nextInt()));
    }

    public static void main(String[] args) {
        Solution10 solution = new Solution10();
        solution.run();
    }
}
