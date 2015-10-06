package ch5;

/**
 * Created by thushy on 2015/10/2.
 */
public class Solution07 {

    public int pairwiseSwap(int n) {
        return ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        Solution07 solution = new Solution07();
        System.out.println(Integer.toBinaryString(solution.pairwiseSwap(0xAAAAAAAA)));
    }
}
