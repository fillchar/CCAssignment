/**
 * Created by floyd on 9/10/2015.
 */
public class Solution09 {

    public boolean stringRotation(String s1, String s2) {
        s2 = s2 + s2;
        return s2.contains(s1);
    }

}
