package ch2;

import java.util.Scanner;

/**
 * Created by floyd on 2015/9/15.
 */
public class Solution06 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode invert(ListNode node) {
        if (node == null) return null;
        ListNode h = invert(node.next);
        if (h != null) {
            node.next.next = node;
            node.next = null;
            return h;
        }
        return node;
    }

    // with O(1) extra space, invert the last half of linked list
    private boolean palindrome(ListNode head) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode h1 = h, h2 = h;
        while (h2 != null && h2.next != null) {
            h1 = h1.next;
            h2 = h2.next.next;
        }
        ListNode node = invert(h1.next);
        while (node != null) {
            if (head.val != node.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode virtual = new ListNode(-1), tail = virtual;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        System.out.println(palindrome(virtual.next));
    }

    public static void main(String[] args) {
        Solution06 solution = new Solution06();
        solution.run();
    }

}
