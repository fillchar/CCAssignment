package ch5;

/**
 * Created by thushy on 2015/10/2.
 */
public class Solution02 {

    public String binaryToString(float f) {
        String ret = "0.";
        while (f != 0) {
            f = f * 2;
            if (f >= 1) {
                ret += '1';
                f -= 1;
            }
            else ret += '0';
            if (ret.length() > 32) {
                ret = "ERROR";
                break;
            }
        }
        return ret;
    }

    public void run() {
        System.out.println(binaryToString(0.25f));
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        solution.run();
    }

}
