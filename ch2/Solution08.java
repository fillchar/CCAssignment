package ch2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution08 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode loopDetection(ListNode node) {
        ListNode h1 = node, h2 = node;
        while (h2 != null && h2.next != null) {
            h1 = h1.next;
            h2 = h2.next.next;
            if (h1 == h2) break;
        }
        if (h2 == null || h2.next == null) return null;
        h1 = node;
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode virtual = new ListNode(-1), tail = virtual;
        Map<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (map.containsKey(val)) {
                tail.next = map.get(val);
                break;
            }
            else {
                tail.next = new ListNode(val);
                tail = tail.next;
                map.put(val, tail);
            }
        }
        ListNode node = loopDetection(virtual.next);
        if (node != null) System.out.println(node.val);
        else System.out.println(node);
    }

    public static void main(String[] args) {

        Solution08 solution = new Solution08();
        solution.run();
    }

}
