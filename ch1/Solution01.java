package ch1;

import java.util.*;

public class Solution01 {

    // using set
    public boolean isUniqueWithSet(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) return false;
            set.add(str.charAt(i));
        }
        return true;
    }

    // without extra data structure
    public boolean isUnique(String str) {
        byte[] bytes = str.getBytes();
        Arrays.sort(bytes);
        for (int i = 1; i < str.length(); i++)
            if (bytes[i] == bytes[i - 1]) return false;
        return true;
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isUnique(str));
        //System.out.println(isUniqueWithSet(str));
    }

    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        solution.run();
    }


}