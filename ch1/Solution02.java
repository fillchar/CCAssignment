package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */

public class Solution02 {

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

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine(), str2 = scanner.nextLine();
        System.out.println(checkPermutation(str1, str2));
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        solution.run();
    }

}
