package strings;

import java.util.Arrays;

public class UniqueString {

    /*
       Runtime: O(N)
       - for loop: 128 iterations
       - indexOf: N
       - lastIndexOf: N
     */
    public static boolean solution1(String s) {
        if(s == null) {
            return true;
        }

        if(s.length() > 128) {
            return false;
        }

        for(int i = 0; i <= 127; i++) {
            if(s.indexOf((char)i) != s.lastIndexOf((char)i)) {
                return false;
            }
        }
        return true;
    }

    /*
     Runtime: O(N)
     Space: O(N)
     */
    public static boolean solution2(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }

        char[] c = s.toCharArray();
        Arrays.sort(c);

        for(int i = 0; i < c.length-1; i++) {
            if(c[i] == c[i+1]) {
                return false;
            }
        }
        return true;
    }
}
