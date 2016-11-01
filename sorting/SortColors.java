package sorting;


public class SortColors {
    public void solution(int[] nums) {
        if(nums == null || nums.length <= 0) {
            return ;
        }

        // iterate through array, update counts for 0s, 1s and 2s
        // iterate over a second time, overwriting original array values with number of 0s, 1s, 2s

        int numZeros = 0;
        int numOnes = 0;
        int numTwos = 0;
        for(int i = 0; i < nums.length; i++) {
            switch(nums[i]) {
                case 0: numZeros++;
                    break;
                case 1: numOnes++;
                    break;
                case 2: numTwos++;
                    break;
                default: continue;
            }
        }

        helper(nums, 0, numZeros - 1, 0);
        helper(nums, numZeros, numZeros + numOnes - 1, 1);
        helper(nums, numZeros + numOnes, numZeros + numOnes + numTwos - 1, 2);

    }

    public void helper(int[] nums, int lo, int hi, int val) {
        if (hi >= nums.length) return;
        for (int i = lo; i <= hi; i++) {
            nums[i] = val;
        }
    }
}
