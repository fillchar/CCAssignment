import java.util.*;

/**
 * Created by thushy on 2015/9/9.
 */
public class Solution {

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

    public void uRLify(char[] str, int size) {
        int sizeRet = size;
        for (int i = 0; i < size; i++)
            if (str[i] == ' ') sizeRet += 2;
        for (int i = size - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--sizeRet] = '0';
                str[--sizeRet] = '2';
                str[--sizeRet] = '%';
            } else str[--sizeRet] = str[i];
        }
    }

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

    public String stringCompression(String str) {
        String ret = "";
        int cnt = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                ret += str.charAt(i - 1);
                ret += cnt;
                cnt = 0;
            } else cnt++;
        }
        ret += str.charAt(str.length() - 1);
        ret += cnt;
        if (ret.length() >= str.length()) ret = str;
        return ret;
    }

    public void rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++ )
            for (int j = i; j < size - i - 1; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
                matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                matrix[j][size - i - 1] = t;
            }
    }

    public void zeroMatrix(int[][] matrix) {
        Set<Integer> row = new HashSet<>(), col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
        for (int i : row)
            for (int j = 0; j < matrix[i].length; j++) matrix[i][j] = 0;
        for (int i : col)
            for (int j = 0; j < matrix.length; j++) matrix[j][i] = 0;
    }

    public boolean stringRotation(String s1, String s2) {
        s2 = s2 + s2;
        return s2.contains(s1);
    }

    private ListNode remove(ListNode node, ListNode tar) {
        if (node == null) return null;
        if (node.val == tar.val) return remove(node.next, tar);
        else {
            node.next = remove(node.next, tar);
            return node;
        }
    }

    public void removeDups(ListNode node) {
        while (node != null) {
            node.next = remove(node.next, node);
            node = node.next;
        }
    }

    public ListNode returnKthToLast(ListNode node, int k) {
        int cnt = 0;
        for (ListNode tmp = node; tmp != null; tmp = tmp.next) cnt++;
        for (cnt = cnt - k; cnt > 0; cnt--) node = node.next;
        return node;
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

    Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        Integer ret = map.get(n);
        if (ret != null) return ret.intValue();
        int size = (int) Math.sqrt(n), min = 0x7FFFFFFF;
        for (int i = 0; i <= size; i++)
            min = Math.min(min, 1 + numSquares(n - i * i));
        map.put(n, min);
        return min;
    }

}
