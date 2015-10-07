package ch5;

/**
 * Created by thushy on 2015/10/6.
 */
public class Solution04 {

    public int nextLargestNumber(int n) {
        int pos = 0;
        for (; pos < 32 && (n & (1 << pos)) == 0; pos++);
        if (pos == 32) return -1;
        int cnt0 = pos;
        for (; pos < 32 && (n & (1 << pos)) != 0; pos++);
        if (pos == 32) return -1;
        int cnt1 = pos - cnt0;
        n -= n & ((1 << pos) - 1);
        n = n | (1 << pos);
        for (int i = 0; i < cnt1 - 1; i++ ) n += 1 << i;
        return n;
    }

    public int nextSmallestNumber(int n) {
        int pos = 0;
        for (; pos < 32 && (n & (1 << pos)) != 0; pos++);
        if (pos == 32) return -1;
        int cnt1 = pos;
        for (; pos < 32 && (n & (1 << pos)) == 0; pos++);
        if (pos == 32) return -1;
        int cnt0 = pos - cnt1;
        n = n | ((1 << pos) - 1);
        n -= (1 << pos);
        for (int i = 0; i < cnt0 - 1; i++ ) n -= 1 << i;
        return n;
    }

    public void run() {
        System.out.println(Integer.toBinaryString(0x2F8F));
        System.out.println(Integer.toBinaryString(nextLargestNumber(0x2F0)));
        System.out.println(Integer.toBinaryString(nextSmallestNumber(0x2F8F)));
        int i = 0xFFFFFF00;
        byte b = (byte) i;
        System.out.println(b);
    }

    public static void main(String[] args) {
        Solution04 solution = new Solution04();
        solution.run();
    }

}
