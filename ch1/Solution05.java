package ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution05 {

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

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine(), str2 = scanner.nextLine();
        System.out.println(oneAway(str1, str2));
    }

    public static void main(String[] args) {
        Solution05 solution = new Solution05();
        solution.run();
    }

}
