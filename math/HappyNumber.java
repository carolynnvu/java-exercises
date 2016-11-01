package math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    // Runtime: O(n)
    // Space: O(n)
    public static boolean isHappy(int n) {
        int currNum = n;
        Set<Integer> set = new HashSet<>();
        while((currNum != 1) && (!set.contains(currNum))) {
            set.add(currNum);
            currNum = getSumOfSquares(currNum);
        }
        return currNum == 1;
    }

    private static int getSumOfSquares(int n){
        int currNum = n;
        int result = 0;
        while(currNum > 0 ) {
            int d = currNum%10;
            result = result + d*d;
            currNum = currNum/10;
        }
        return result;
    }

    /*
     * Sum won't go over 2^32 - 1 approx 2billion.
     * example...1,999,999,999 = 1 + (81*9) = 1 + 729 = 730
     * so we don't have to worry about overflow for n
     */
}
