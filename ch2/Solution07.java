package ch2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by floyd on 2015/9/15.
 */
public class Solution07 {

    public class ListNode {
        public ListNode next;
        public int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    // the solution on CC150 is wrong in some cases, for example, if there is a cycle in the linked list....

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

    private ListNode intersection(ListNode h1, ListNode h2) {
        ListNode loop1 = loopDetection(h1), loop2 = loopDetection(h2);
        if (loop1 == null && loop2 == null || loop1 == loop2) {
            int size1 = 0, size2 = 0;
            for (ListNode node = h1; node != loop1; node = node.next) size1++;
            for (ListNode node = h2; node != loop2; node = node.next) size2++;
            if (size1 > size2) {
                ListNode node = h1;
                h1 = h2;
                h2 = node;
            }
            for (; size1 != size2; size2--)
                h2 = h2.next;
            while (h2 != loop2) {
                if (h1 == h2) return h2;
                h2 = h2.next;
                h1 = h1.next;
            }
            return loop2;
        }
        if (loop1 == null || loop2 == null) return null;

        // other wise it is hard to define the intersection node
        // we define it as has the minimum average distance to h1 and h2

        // check whether these two cycle are the same one
        boolean flag = false;
        for (ListNode node = loop1.next; node != loop1; node = node.next)
            if (node == loop2) flag = true;
        if (!flag) return null;
        int dist = 0;
        for (ListNode node = h1; node != loop1; node = node.next) dist++;
        for (ListNode node = h2; node != loop1; node = node.next) dist++;
        for (ListNode node = h1; node != loop2; node = node.next) dist--;
        for (ListNode node = h2; node != loop2; node = node.next) dist--;
        return dist > 0 ? loop2 : loop1;

    }

    // using integer to set the value of ListNode instead of char
    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        ListNode virtual1 = new ListNode(-1), tail1 = virtual1;
        ListNode virtual2 = new ListNode(-1), tail2 = virtual2;
        Map<Integer, ListNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            if (map.containsKey(val)) {
                tail1.next = map.get(val);
                break;
            }
            else {
                tail1.next = new ListNode(val);
                tail1 = tail1.next;
                map.put(val, tail1);
            }
        }
        for (int i = 0; i < m; i++) {
            int val = scanner.nextInt();
            if (map.containsKey(val)) {
                tail2.next = map.get(val);
                break;
            }
            else {
                tail2.next = new ListNode(val);
                tail2 = tail2.next;
                map.put(val, tail2);
            }
        }
        ListNode node = intersection(virtual1.next, virtual2.next);
        if (node != null) System.out.println(node.val);
        else System.out.println(node);
    }

    public static void main(String[] args) {

        Solution07 solution = new Solution07();
        solution.run();
    }

}
