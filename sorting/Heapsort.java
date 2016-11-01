package sorting;


public class Heapsort {

    /*
     * O(N log N) in place implementation of heapsort
     */
    public static void solution(int[] nums) {
        if(nums == null || nums.length <= 0) return ;

        buildMaxHeap(nums);
        sort(nums);
    }

    // O(N) operation
    private static void buildMaxHeap(int[] nums) {
        int parentIndex;
        int tempIndex;
        for(int i = 0; i < nums.length; i++) {
            parentIndex = Math.floorDiv(Math.abs((i-1)),2);
            if(nums[i] > nums[parentIndex]) {
                tempIndex = i;
                parentIndex = Math.floorDiv(Math.abs((tempIndex-1)),2);
                do {
                    swap(nums, tempIndex, parentIndex);
                    tempIndex = Math.floorDiv(Math.abs((tempIndex-1)),2);
                    parentIndex = Math.floorDiv(Math.abs((tempIndex-1)),2);
                } while((tempIndex >= 0) && (nums[tempIndex] > nums[parentIndex]));
            }
        }
    }

    private static void siftDown(int[] nums, int heapSz) {
        int heapSize = heapSz;
        int maxNodeIndex = 0;
        int leftChildIndex;
        int rightChildIndex;
        int pointer = maxNodeIndex;
        boolean heapPropertyBroken = true;

        while(heapPropertyBroken) {
            leftChildIndex = (2*maxNodeIndex) + 1;
            rightChildIndex = (2*maxNodeIndex) + 2;
            if((leftChildIndex < heapSize) && (nums[leftChildIndex] > nums[maxNodeIndex])) {
                maxNodeIndex = leftChildIndex;
            }
            if((rightChildIndex < heapSize) && (nums[rightChildIndex] > nums[maxNodeIndex])) {
                maxNodeIndex = rightChildIndex;
            }
            if(maxNodeIndex != pointer) {
                swap(nums, pointer, maxNodeIndex);
                pointer = maxNodeIndex;
            }
            else {
                heapPropertyBroken = false;
            }
        }
    }

    private static void sort(int[] nums) {
        int heapSize = nums.length;
        int temp;
        int parentIndex = 0;

        while(heapSize > 0 ) {
            temp = nums[parentIndex];
            nums[parentIndex] = nums[heapSize - 1];
            nums[heapSize - 1] = temp;
            heapSize--;
            siftDown(nums, heapSize);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void test() {
        int[] test = { 6, 5, 3, 1, 8, 7, 2, 4 };
        for(Integer i : test) System.out.printf("%4d ", i);
        solution(test);
        System.out.println();
        for(Integer i : test) System.out.printf("%4d ", i);

    }
}
