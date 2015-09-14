/**
 * Created by floyd on 9/10/2015.
 */
public class Solution06 {

    public String stringCompression(String str) {
        String ret = "";
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                ret += str.charAt(i);
                ret += cnt;
                cnt = 0;
            } else cnt++;
        }
        if (ret.length() >= str.length()) ret = str;
        return ret;
    }

}
