package ch5;

/**
 * Created by thushy on 2015/10/2.
 */
public class Solution03 {

    public int flipBitToWin(int n) {
        int i = 0, l1 = -1, l2 = -1;
        int ret = 0;
        for (; (1 << i) <= n; i++) {
            if ((n & (1 << i)) == 0) {
                //System.out.println(l1 + " " + l2);
                ret = Math.max(ret, i - l2 - 1);
                l2 = l1;
                l1 = i;
            }
        }
        ret = Math.max(ret, i - l2 - 1);
        return ret;
    }

    public void run() {
        System.out.println(flipBitToWin(1775));
    }

    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        solution.run();
    }
}
