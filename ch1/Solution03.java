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

}
