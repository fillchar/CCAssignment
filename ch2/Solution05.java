import java.util.ArrayList;
import java.util.List;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution05 {

    public boolean oneAway(String s1, String s2) {
        int size1 = s1.length(), size2 = s2.length();
        if (Math.abs(size1 - size2) > 1) return false;
        if (size1 == size2) {
            int cnt = 0;
            for (int i = 0; i < size1; i++)
                if (s1.charAt(i) != s2.charAt(i)) cnt++;
            return cnt < 2;
        }
        if (size1 > size2) {
            String t = s1;
            s1 = s2;
            s2 = t;
            size1 = size2;
        }
        int prefix = 0;
        while (prefix < size1 && s1.charAt(prefix) == s2.charAt(prefix)) prefix++;
        while (prefix < size1 && s1.charAt(prefix) == s2.charAt(prefix + 1)) prefix++;
        return prefix >= size1;
    }

    public ListNode sumLists(ListNode node1, ListNode node2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (; node1 != null; node1 = node1.next)
            list1.add(node1.val);
        for (; node2 != null; node2 = node2.next)
            list2.add(node2.val);
        if (list1.size() > list2.size()) {
            List<Integer> t = list1;
            list1 = list2;
            list2 = t;
        }
        int[] arr = new int[list2.size()];
        for (int i = list1.size() - 1; i >= 0; i--)
            arr[list2.size() - list1.size() + i] =  list1.get(i) + list2.get(list2.size() - list1.size() + i);
        for (int i = list2.size() - 1; i > 0; i--)
            if (arr[i] > 9) {
                arr[i] -= 10;
                arr[i - 1]++;
            }
        ListNode head = new ListNode(-1), tail = head;
        if (arr.length > 0 && arr[0] > 9) {
            head.next = new ListNode(1);
            tail = head.next;
            arr[0] -= 10;
        }
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }

}
