import arrays.MajorityElement;
import dp.RangeSumQuery;
import math.IsPowerOfTwo;
import misc.SimpleMovingAverage;
import sorting.MergeSort;

public class Main {

    public static void main(String[] args) {
        int a = 4;
        int b = a;
        a = 6;
        System.out.println(b);
    }


    public static void testSMA() {
        double[] test = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
        int[] periods = {3,5};
        for (int period : periods) {
            SimpleMovingAverage ma = new SimpleMovingAverage(period);
            for (double x : test) {
                ma.addData(x);
                System.out.println("Next number = " + x + ", SMA = " + ma.getAverage());
            }
            System.out.println();
        }
    }
}
