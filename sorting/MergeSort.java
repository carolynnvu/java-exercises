package sorting;


public class MergeSort {

    public static void solution(int[] nums) {
        mergeSort(nums);
    }

    public static void mergeSort(int[] nums) {
        if(nums == null || nums.length <= 1) return ;

        int[] helper = new int[nums.length];
        int lo = 0;
        int hi = nums.length - 1;
        mergeSort(nums, helper, lo, hi);
    }

    public static void mergeSort(int[] nums, int[] helper, int lo, int hi) {
        if(lo < hi) {
            int mid = (lo + hi)/2;
            mergeSort(nums, helper, lo, mid);
            mergeSort(nums, helper, mid+1, hi);
            merge(nums, helper, lo, mid, hi);
        }
    }

    public static void merge(int[] nums, int[] helper, int lo, int mid, int hi) {
        //copy half of array to auxiliary
        for(int i = lo; i <= hi; i++) {
            helper[i] = nums[i];
        }

        int leftHelper = lo;
        int rightHelper = mid + 1;
        int currPos = lo;

        while((leftHelper <= mid) && (rightHelper <= hi)) {
            if(helper[leftHelper] <= helper[rightHelper]) {
                nums[currPos++] = helper[leftHelper++];
            }
            else if(helper[rightHelper] < helper[leftHelper]) {
                nums[currPos++] = helper[rightHelper++];
            }
        }

    //Need to merge in the rest of the left-side elements. e.g. array [ 10, 11, 12 || 2, 3, 4] → [ 2, 3, 4 || 2, 3, 4] and rightHelper == hi
        int remaining = mid - leftHelper;
        for(int i = 0; i <= remaining; i++) {
            nums[currPos + i] = helper[leftHelper+i];
        }
    }

    public static void test() {
        int[] test1 = { 10, 11, 12, 2, 3, 4 };
        solution(test1);
        for(Integer i : test1) System.out.printf("%4d ", i);
    }

}
