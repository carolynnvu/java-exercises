package sorting;


public class QuickSort {

    /*
     * Runtime: O(N Log N) avg: O(N^2)
     * Choose last element as pivot
     */
    public static void quickSort(int[] array, int start, int end){
        if (start >= end){
            return;
        }

        int pivotPos = end;
        int pivot = array[pivotPos];
        int newPivotPos = start;
        for (int i = start; i < end; i++){
            if (array[i] < pivot){
                newPivotPos++; //skip over elements that are less than pivot
            }
        }
        //swap pivot values into place
        swap(array, newPivotPos, pivotPos);

        quickSort(array, start, newPivotPos- 1);
        quickSort(array, newPivotPos + 1, end);
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void test() {
        int[] test1 = {1, 2, 3, 4};
        System.out.println("Test case 1");
        testHelper(test1);

        int[] test2 = {4, 9, 1};
        System.out.println("Test case 2");
        testHelper(test2);

        System.out.println("Test case 3");
        int[] test3 = { -1, 1, 0};
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
        quickSort(nums, 0, nums.length-1);
        System.out.print("Sorted array: ");
        for(int i : nums) System.out.printf("%4d", i);
        System.out.println();
    }
}
