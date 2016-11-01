package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class GroupAnagrams {

    /*
     * Use a hashmap where the key is the sorted anagram and the value is a list of anagrams in the given array.
     *  Build the result array from this hashmap.
     */

    public static void solution(String[] strs) {
        if(strs == null || strs.length <= 2) return ;

        Map<String, List<String>> m = new HashMap<>();

        //Build hashmap
        for(String s : strs) {
            String sortedKey = sort(s);
            if(!m.containsKey(sortedKey)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                m.put(sortedKey, list);
            } else {
                m.get(sortedKey).add(s);
            }
        }

        //Build result array
        int i = 0;
        for(String key : m.keySet()) {
            for(String s : m.get(key)) {
                strs[i++] = s;
            }
        }
    }

    private static String sort(String s) {
        char[] sort = s.toCharArray();
        Arrays.sort(sort);
        return String.valueOf(sort);
    }

    public static void test() {
        System.out.println("Test 1: ");
        String[] test1 = { "ear", "are", "car" };
        solution(test1);
        for(String s : test1) System.out.printf(" " + s);
        System.out.println();


        System.out.println("Test 2: ");
        String[] test2 = { "apple", "banana", "clementine" };
        solution(test2);
        for(String s: test2) System.out.printf(" " + s);
        System.out.println();
    }

}
