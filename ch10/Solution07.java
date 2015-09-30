package ch10;

import java.io.*;
import java.util.Scanner;

/**
 * Created by floyd on 2015/9/29.
 */
public class Solution07 {

    public long missingInt(File file) {
        long[] cover = new long[1 << 26];
        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLong()) {
                Long num = scanner.nextLong();
                int pos = (int) (num >> 6);
                cover[pos] = cover[pos] | ((long) 1 << (num & 0x3F));
            }
            int pos;
            for (pos = 0; cover[pos] == Long.MIN_VALUE; pos++);
            for (int i = 0; i < 64; i++)
                if ((cover[pos] & (1 << i)) == 0) return (long) pos * 64 + i;
            return (long) 1 << 32;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
