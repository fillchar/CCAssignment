package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution06 {

    public String stringCompression(String str) {
        String ret = "";
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                ret += str.charAt(i);
                ret += cnt;
                cnt = 1;
            } else cnt++;
        }
        if (ret.length() >= str.length()) ret = str;
        return ret;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(stringCompression(str));
    }

    public static void main(String[] args) {
        Solution06 solution = new Solution06();
        solution.run();
    }

}
