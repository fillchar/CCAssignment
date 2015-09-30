package ch10;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by thushy on 2015/9/23.
 */
public class Solution11 {
    // O(n log n)
    public void peakAndValleysSorted(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int r = tmp.length >> 1, l = r - 1, pos = 0;
        while (l >= 0) {
            nums[pos++] = tmp[r++];
            nums[pos++] = tmp[l--];
        }
        if (r < nums.length) nums[pos] = tmp[r];
    }

    int getMax(int[] nums, int pos) {
        int a = nums[pos - 1], b = nums[pos], c = pos < nums.length - 1 ? nums[pos + 1] : 0x80000000;
        if (c > b && c > a) return pos + 1;
        if (a > c && a > b) return pos - 1;
        return pos;
    }

    // O(n)
    public void peakAndValleys(int[] nums) {
        for (int i = 1; i < nums.length; i += 2) {
            int pos = getMax(nums, i), t = nums[i];
            nums[i] = nums[pos];
            nums[pos] = t;
        }
    }

    public void run() {
        Random rand = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt(100);
        for (int i : a) System.out.print(i + " ");
        System.out.println();
        peakAndValleys(a);
        for (int i : a) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        solution.run();
    }

}
