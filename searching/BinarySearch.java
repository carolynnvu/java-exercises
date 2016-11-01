package searching;

public class BinarySearch {

    /*
     * Runtime: O(log N)
     * Space: O(1)
     */
    public static boolean iterativeSolution(int[] nums, int target) {
        if(nums == null || nums.length <= 0) return false;

        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while(lo <= hi) {
            mid = (lo + hi) / 2;
            if(nums[mid] < target) {
                lo = mid + 1;
            } else if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /*
     * Runtime: O(log N)
     * Space: O(log N)
     */
    public static boolean recursiveSolution(int[] nums, int target) {
        if(nums == null || nums.length <= 0) return false;

        return rec(nums, 0, nums.length-1, target);
    }

    public static boolean rec(int[] nums, int lo, int hi, int target) {
        if(lo > hi) return false;

        int mid = (lo + hi) / 2;
        if(nums[mid] > target) return rec(nums, lo, mid-1, target);
        if(nums[mid] < target) return rec(nums, mid+1, hi, target);
        return true;
    }


    public static void test() {
        int[] test1 = { 100 };
        System.out.print("Test 1 should return true: ");
        System.out.println(iterativeSolution(test1, 100));

        int[] test2 = { 100, 200 };
        System.out.print("Test 2 should return true: ");
        System.out.println(iterativeSolution(test2, 100));

        int[] test3 = { 100, 200, 300 };
        System.out.print("Test 3 should return true: ");
        System.out.println(iterativeSolution(test3, 200));

        int[] test4 = { 100 };
        System.out.print("Test 4 should return true: ");
        System.out.println(recursiveSolution(test4, 100));

        int[] test5 = { 100, 200 };
        System.out.print("Test 5 should return true: ");
        System.out.println(recursiveSolution(test5, 100));


        int[] test6 = { 333, 332, 331 };
        System.out.print("Test 6 should return false: ");
        System.out.println(recursiveSolution(test6, 555));
    }
}
