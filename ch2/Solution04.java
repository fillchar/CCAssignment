package ch2;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution04 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode partition(ListNode node, int tar) {
        ListNode head1 = new ListNode(-1), node1 = head1, head2 = new ListNode(-1), node2 = head2;
        for (ListNode n = node; n != null; n = n.next) {
            if (n.val < tar) {
                node1.next = n;
                node1 = n;
            } else {
                node2.next = n;
                node2 = n;
            }
        }
        node2.next = null;
        node1.next = head2.next;
        return head1.next;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), tar = scanner.nextInt();
        ListNode virtual = new ListNode(-1), tail = virtual;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        for (tail = partition(virtual.next, tar); tail != null; tail = tail.next)
            System.out.print(tail.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution04 solution = new Solution04();
        solution.run();
    }

}
