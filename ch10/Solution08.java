package ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by floyd on 2015/9/29.
 */
public class Solution08 {

    // suppose input use no memory, or we should read the number in file.
    // use less than 10KB extra memory.
    public List<Integer> findDuplicates(int[] nums) {
        int[] cover = new int[1000];
        List<Integer> ret = new ArrayList<>();
        for (int i : nums) {
            int pos = (i - 1) / 32, bias = (i - 1) % 32;
            if ((cover[pos] & (1 << bias)) != 0) ret.add(i);
            else cover[pos] += 1 << bias;
        }
        return ret;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        System.out.println(findDuplicates(nums));
    }

    public static void main(String[] args) {
        Solution08 solution = new Solution08();
        solution.run();
    }
}
