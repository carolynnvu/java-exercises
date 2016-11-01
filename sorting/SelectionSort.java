package sorting;


public class SelectionSort {

    /*
     * Runtime: O(N^2)
     * Space: O(1)
     */
    public static void solution(int[] nums) {
        if(nums == null || nums.length <=1) return ;

        int min;
        int minIndex = 0;
        for(int i = 0; i < nums.length-1; i++) {
            min = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            if(min < nums[i]) {
                int tmp = nums[i];
                nums[i] = min;
                nums[minIndex] = tmp;
            }
        }
    }

    public static void test() {
        int[] test1 = {1, 2, 3};
        System.out.println("Test case 1");
        testHelper(test1);

        int[] test2 = {3, 2, 1};
        System.out.println("Test case 2");
        testHelper(test2);

        System.out.println("Test case 3");
        int[] test3 = { -1, 1, 0};
        testHelper(test3);

        System.out.println("Test case 4");
        int[] test4 = new int[0];
        testHelper(test4);
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
