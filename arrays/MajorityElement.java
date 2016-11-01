package arrays;

import java.util.Arrays;

public class MajorityElement {

    // Runtime: O(n log n)
    // Space: O(1)
    public static int solution(int[] nums) {
        if(nums == null | nums.length <= 0) return Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];

        Arrays.sort(nums);

        int lo = 0;
        int hi = 0;
        int currMax = Integer.MIN_VALUE;
        int currMaxDiff = 0;
        int currInt = nums[lo];

        while(hi < nums.length) {
            while((hi < nums.length) && (currInt == nums[hi])) {
                hi++;
            }
            currMaxDiff = ((hi - lo) >= currMaxDiff ? (hi-lo) : currMaxDiff);

            if((hi - lo) >= currMaxDiff) {
                currMax = nums[lo];
            }
            System.out.println("hi: " + hi + ", lo: " + lo +  ", currMax: " + currMax);
            if(hi >= nums.length) break;
            currInt = nums[hi];
            lo = hi;
        }
        return (currMaxDiff >= nums.length/2) ? currMax : Integer.MIN_VALUE;
    }

    public static void test() {
        int[] test1 = {-1,1,1,1,2,1};
        System.out.println(solution(test1));

        int[] test2 = {2,2};
        System.out.println(solution(test2));
    }
}
