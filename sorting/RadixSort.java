package sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

    public class RadixSort {
        public static void solution(int[] nums) {
            if(nums == null || nums.length <= 0) return ;

            int RADIX = 10;

            Map<Integer, ArrayList<Integer>> buckets = new HashMap<>();
            for(int i = 0; i < RADIX; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                buckets.put(i, list);
            }

            int unit = 1;
            int digit = Integer.MIN_VALUE;
            int tmp = Integer.MIN_VALUE;
            boolean maxNumMet = false;

            while(!maxNumMet) {
                maxNumMet = true;
                for(Integer i : nums) {
                    tmp = i/unit;
                    digit = tmp%RADIX;
                    buckets.get(digit).add(i);

                    if(maxNumMet && (tmp > 0)) { // if smallerInt / biggerInt → 0
                        maxNumMet = false;
                    }
                }

            //fill the original array
                int index = 0;
                for(int i = 0; i < RADIX; i++) {
                    List<Integer> currList = buckets.get(i);
                    for(Integer n : currList) {
                        nums[index++] = n;
                    }
                    currList.clear();
                }
                unit = unit * RADIX;
        }
    }

    public static void test() {
        int[] test1 = {1, 2, 3, 4};
        System.out.println("Test case 1");
        testHelper(test1);

        int[] test2 = {4, 9, 1};
        System.out.println("Test case 2");
        testHelper(test2);

        System.out.println("Test case 3");
        int[] test3 = { 1, 1, 1};
        testHelper(test3);

        System.out.println("Test case 4");
        int[] test4 = new int[0];
        testHelper(test4);

        System.out.println("Test case 5");
        int[] test5 = { 10, 9, 8, 7};
        testHelper(test5);
    }

    public static void testHelper(int[] nums) {
        System.out.print("Unsorted array: ");
        for(int i : nums) System.out.printf("%4d", i);
        System.out.println();
        solution(nums);
        System.out.print("Sorted array: ");
        for(int i : nums) System.out.printf("%4d", i);
        System.out.println();
    }
}
