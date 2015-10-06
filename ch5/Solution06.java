package ch5;

/**
 * Created by thushy on 2015/10/2.
 */
public class Solution06 {

    public int conversion(int n, int m) {
        return Integer.bitCount(n ^ m);
    }

    public static void main(String[] args) {
        Solution06 solution = new Solution06();
        System.out.println(solution.conversion(29, 15));
    }

}
