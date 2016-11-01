package math;

import java.math.BigDecimal;

public class IsPowerOfTwo {

    public static boolean solution(int n) {
        if(n == 1) return true;
        double result = (double)n;
        while(result >= 4) {
            result = result/2;
        }

        return result == 2.00;
    }

    public static void test() {
        int test1 = 5;
        solution(test1);

        int test2 = 8;
        solution(test2);

        int test3 = 1;
        solution(test3);
    }
}
