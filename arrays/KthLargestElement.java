package arrays;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class KthLargestElement {

    // Runtime: O(n log n)
    // Space: O(k)...worst O(n)
    public static int solution(int[] nums, int k) {
        if(nums == null || nums.length <= 0) return Integer.MIN_VALUE;
        //clarify with whoever's asking the question if k should be validated
        //here we assume k is 1 <= k <= nums.length

        Arrays.sort(nums);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = nums.length-1; i >= 0; i--) {
            if(!stack.contains(nums[i])) {
                stack.addLast(nums[i]);
            }
            if(i == (nums.length - k)) break;
        }
        return stack.removeLast();
    }
}
