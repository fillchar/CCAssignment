/**
 * Created by floyd on 9/10/2015.
 */
public class Solution02 {

    public boolean checkPermutation(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) return false;
        int[] cnt = new int[128];
        for (int i = 0; i < s1.length(); i++) cnt[s1.charAt(i)]++;
        for (int i = 0; i < s2.length(); i++)
            if (--cnt[s2.charAt(i)] < 0) return false;
        return true;
    }

    public ListNode returnKthToLast(ListNode node, int k) {
        int cnt = 0;
        for (ListNode tmp = node; tmp != null; tmp = tmp.next) cnt++;
        for (cnt = cnt - k; cnt > 0; cnt--) node = node.next;
        return node;
    }

}
