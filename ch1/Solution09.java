package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution09 {

    // check whether str1 is a substring of str2
    private boolean isSubstring(String str1, String str2) {
        return str2.contains(str1);
    }

    public boolean stringRotation(String s1, String s2) {
        return isSubstring(s1, s2 + s2);
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine(), str2 = scanner.nextLine();
        System.out.println(stringRotation(str1, str2));
    }

    public static void main(String[] args) {
        Solution09 solution = new Solution09();
        solution.run();
    }

}
