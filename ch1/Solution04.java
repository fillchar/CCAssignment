/**
 * Created by floyd on 9/10/2015.
 */
public class Solution04 {

    public boolean PalindromePermutation(String str) {
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

}
