package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution05 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode sumLists(ListNode node1, ListNode node2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (; node1 != null; node1 = node1.next)
            list1.add(node1.val);
        for (; node2 != null; node2 = node2.next)
            list2.add(node2.val);
        int[] arr = new int[Math.max(list2.size(), list1.size()) + 1];
        for (int i = 0; i < list2.size(); i++) arr[i] = list2.get(i);
        for (int i = 0; i < list1.size(); i++)
            arr[i] +=  list1.get(i);
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > 9) {
                arr[i] -= 10;
                arr[i + 1]++;
            }
        ListNode head = new ListNode(-1), tail = head;
        for (int i = 0; i < arr.length - 1; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        if (arr[arr.length - 1] > 0) tail.next = new ListNode(1);
        return head.next;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ListNode virtual1 = new ListNode(-1), tail1 = virtual1;
        ListNode virtual2 = new ListNode(-1), tail2 = virtual2;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            tail1.next = new ListNode(val);
            tail1 = tail1.next;
        }
        for (int i = 0; i < m; i++) {
            int val = scanner.nextInt();
            tail2.next = new ListNode(val);
            tail2 = tail2.next;
        }
        for (ListNode node = sumLists(virtual1.next, virtual2.next); node != null; node = node.next)
            System.out.print(node.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        solution.run();
    }

}
