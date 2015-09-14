import java.util.*;

public class Solution01 {

    // using set
    public boolean isUniqueWithSet(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }

    // without extra data structure
    public boolean isUnique(String str) {
        byte[] bytes = str.getBytes();
        Arrays.sort(bytes);
        for (int i = 1; i < str.length(); i++)
            if (bytes[i] == bytes[i - 1]) return false;
        return true;
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
                n = n.next;
                set.add(node.val);
            }
            node = node.next;
        }
    }

}