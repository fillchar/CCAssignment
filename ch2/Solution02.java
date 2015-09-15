package ch2;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution02 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode returnKthToLast(ListNode node, int k) {
        int cnt = 0;
        for (ListNode tmp = node; tmp != null; tmp = tmp.next) cnt++;
        for (cnt = cnt - k; cnt > 0; cnt--) node = node.next;
        return node;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        ListNode virtual = new ListNode(-1), tail = virtual;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        System.out.println(returnKthToLast(virtual.next, k).val);
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        solution.run();
    }

}
