package strings;


public class LongestCommonPrefix {

    public static String solution(String[] strs) {
        if(strs == null || strs.length <= 0) return new String();

        if(strs.length == 1) return strs[0];

        //Use first word in array as lcp
        String lcp = strs[0];

        int len = lcp.length() - 1;
        while(len >= 0) {
            //Check if each of the succeeding words contains lcp as prefix
            for(int i = 1; i < strs.length; i++) {
                if(strs[i].indexOf(lcp) != 0) { //If current word doesn't contain lcp, reduce lcp by one character
                    lcp = lcp.substring(0, lcp.length() - 1);
                    i = strs.length; //Set i to strs.length to get out of for loop
                }
            }
            len--;
        }
        return lcp;
    }


    public static void test() {
        String[] test1 = { "flower", "flow" };
        System.out.println("Test 1: " + solution(test1));


        String[] test2 = { "flower", "flow", "soupcan" };
        System.out.println("Test 2: " + solution(test2));
    }
}
