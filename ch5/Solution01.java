package ch5;

/**
 * Created by thushy on 2015/10/2.
 */
public class Solution01 {

    public int insertion(int m, int n, int i, int j) {
        int size = j - i + 1;
        return (m & ~(((1 << size) - 1) << i)) | (n << i);
    }

    public void run() {
        System.out.println(Integer.toBinaryString(insertion((1 << 10) + 4, 0x13, 2, 6)));
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        solution.run();
    }
}
