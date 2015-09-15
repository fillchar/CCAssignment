package ch2;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution03 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void deleteMiddleNode(ListNode node) throws Exception{
        if (node == null) throw new Exception("input is null");
        if (node.next == null) throw new Exception("try to delete last node of the list");
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ListNode virtual = new ListNode(-1), tail = virtual, tar = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            tail.next = new ListNode(val);
            tail = tail.next;
            if (i == m - 1) tar = tail;
        }
        try {
            deleteMiddleNode(tar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // removeDupsWithSet(virtual.next);
        for (tail = virtual.next; tail != null; tail = tail.next)
            System.out.print(tail.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        solution.run();
    }

}
