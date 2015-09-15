package ch2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution01 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode remove(ListNode node, ListNode tar) {
        if (node == null) return null;
        if (node.val == tar.val) return remove(node.next, tar);
        else {
            node.next = remove(node.next, tar);
            return node;
        }
    }
    // without buffer
    public void removeDups(ListNode node) {
        while (node != null) {
            node.next = remove(node.next, node);
            node = node.next;
        }
    }

    //with buffer
    public void removeDupsWithSet(ListNode node) {
        ListNode n = new ListNode(-1);
        Set<Integer> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node.val)) n.next = node.next;
            else {
                n.next = node;
                n = n.next;
                set.add(node.val);
            }
            node = node.next;
        }
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
        removeDups(virtual.next);
        // removeDupsWithSet(virtual.next);
        for (tail = virtual.next; tail != null; tail = tail.next)
            System.out.print(tail.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        solution.run();
    }
}