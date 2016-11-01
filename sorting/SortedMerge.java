package sorting;

public class SortedMerge {

    /*
     * Start merging from the back so as to not not shift all the elements.
     * This solution assumes that A has exactly |B| empty slots for B's elements.
     */
    public static void solution(int[] A, int[] B) {
        if(A == null && B == null) return ;

        int aIndex = findIndexOfLastElement(A);
        int bIndex =  B.length - 1; //B may not be entirely filled, clarify with whoever’s asking the question
        int mergedIndex = A.length - 1;

        while(bIndex >= 0) { //while we haven't merged in all of B yet
            if(aIndex >= 0 && (A[aIndex] > B[bIndex])) {
                A[mergedIndex] = A[aIndex--];
            } else {
                    A[mergedIndex] = B[bIndex--];
            }
            mergedIndex--;
        }
    }

    public static int findIndexOfLastElement(int[] nums) {
        boolean found = false;

        int currIndex = 0;
        while(!found) {
            if(nums[currIndex] == 0) { //Primitive int uninitialized has value of 0
                found = true;
            } else {
                currIndex++;
            }
        }
        return currIndex - 1;
    }


    public static void test() {
        System.out.print("Test 1: ");
        int[] a1 = { 1, 2, 3, 4, 0, 0, 0, 0 };
        int[] b1 = { 1, 2, 3, 4 };
        solution(a1, b1);
        for(Integer i : a1) System.out.printf("%4d", i);
    }
}
