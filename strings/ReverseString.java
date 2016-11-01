package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseString {

    //Runtime: O(N)
    public static String solution(String s) {
        if(s == null || s.trim().equals("")) {
            return "";
        }

        char[] c = s.trim().toCharArray();

        int len = s.length();

        for(int i = 0; i < len/2; i++) {
            char temp = c[i];
            c[i] = c[len - 1 - i];
            c[len - 1 - i] = temp;
        }

        return Arrays.asList(c)
                     .stream()
                     .map(String::valueOf)
                     .collect(Collectors.joining(""));
    }

    /*
        Test cases:
        String t1 = "";
        String t2 = "   ";
        String t3 = " abc ";
        String t4 = "flower";
    */
}
