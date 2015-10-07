package ch5;

/**
 * Created by thushy on 2015/10/6.
 */
public class Solution08 {

    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        width /= 8;
        int startBlock = width * y + x1 / 8, startPos = x1 % 8, endBlock = width * y + x2 / 8, endPos = x2 % 8;
        if (startPos != 0)
            screen[startBlock++] = (byte) ~((1 << startPos) - 1);
        if (endPos != 7)
            screen[endBlock--] = (byte) ((1 << endPos) - 1);
        for (int i = startBlock; i <= endBlock; i++) screen[i] = (byte) 0xFF;
    }

}
