package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution04 {

    public boolean palindromePermutation(String str) {
        // str is a palindrome permutation when there is at most one character occurs odd time.
        str = str.toLowerCase();
        int cntOdd = 0;
        int[] cnt = new int[128];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a' || str.charAt(i) > 'z') continue;
            if ((++cnt[str.charAt(i)] & 1) == 1) cntOdd++;
            else cntOdd--;
        }
        return cntOdd < 2;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(palindromePermutation(str));
    }

    public static void main(String[] args) {
        Solution04 solution = new Solution04();
        solution.run();
    }

}
