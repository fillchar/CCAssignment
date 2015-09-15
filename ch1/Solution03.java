package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution03 {

    public void uRLify(char[] str, int size) {
        int sizeRet = size;
        for (int i = 0; i < size; i++)
            if (str[i] == ' ') sizeRet += 2;
        for (int i = size - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--sizeRet] = '0';
                str[--sizeRet] = '2';
                str[--sizeRet] = '%';
            } else str[--sizeRet] = str[i];
        }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.trim();
        int size = str.length();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ') size += 2;
        char[] chars = new char[size];
        for (int i = 0; i < str.length(); i++)
            chars[i] = str.charAt(i);
        uRLify(chars, str.length());
        System.out.print(chars);
    }

    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        solution.run();
    }

}
