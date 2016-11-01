package heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSlidingWindow {

    //Runtime: O(N log N) where N is the length of given array
    public static int[] solution(int[] a, int k) {
        if(a == null || a.length <= 0) {
            return new int[0];
        }

        if(k <= 0 || k > a.length) {
            Arrays.sort(a);
            return new int[]{a[a.length - 1]};
        }

        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        //Add first k-1 elements to max heap
        for(int i = 0; i < k - 1; i++) {
            p.add(a[i]);
        }

        int[] res = new int[a.length - k + 1];
        int resIndex = 0;

        //First iteration is at element k in the array, which means we start building the solution array
        for(int i = k-1; i < a.length; i ++) {
            p.add(a[i]); //Insertion takes O(log n) to maintain heap order
            res[resIndex++] = p.peek(); //Node with highest values always at root
            p.remove(a[i - k + 1]); //Slide the window!
        }
        return res;
    }
}
