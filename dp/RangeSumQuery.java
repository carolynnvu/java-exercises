package dp;

import com.google.common.base.Preconditions;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class RangeSumQuery {

    int[] sums;
//    Map<Entry<Integer,Integer>, Integer> sums = new HashMap<>();

    public RangeSumQuery(int[] nums) {
//        Preconditions.checkArgument(nums != null || nums.length > 0, "nums must be an array of ints");
        sums = new int[nums.length + 1];
        calculateSums(nums);
    }

    private void calculateSums(int[] nums) {
//        Entry<Integer, Integer> entry;

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i+1] = sum;
        }

//        for(int i = 0; i <= nums.length-1; i++) {
////            for(int j = i; j <= nums.length-1; j++) {
//                entry = new AbstractMap.SimpleEntry<Integer, Integer>(i, j);
//                sums.put(entry, (i == j ? nums[i] : nums[j] + sums.get(new AbstractMap.SimpleEntry<Integer, Integer>(i, j-1))));
////            }
//        }
    }

    public int getSum(int lo, int hi) {
//        if(hi >= nums.length) throw new RuntimeException("hi must be less than length of array");
//        if(lo > hi) throw new RuntimeException("lo must be less than or equal to hi");
//
//        return sums.get(new AbstractMap.SimpleEntry<Integer, Integer>(lo, hi));
        return sums[hi+1] - sums[lo];
    }
}


