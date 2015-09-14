/**
 * Created by floyd on 9/10/2015.
 */
public class Solution04 {

    public boolean PalindromePermutation(String str) {
        str = str.toLowerCase();
        int cntOdd = 0;
        int[] cnt = new int[128];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a' || str.charAt(i) > 'z') continue;
            if ((++cnt[str.charAt(i)] & 1) == 1) cntOdd++;
            else cntOdd--;
        }
        return cntOdd < 2;
    }

    public void partition(ListNode node, int tar) {
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
    }

}
