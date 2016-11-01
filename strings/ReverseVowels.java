package strings;

public class ReverseVowels {

    /*
     Consider letter casing and white spaces
     Runtime: O(N)
     */
    public static String solution(String str) {
        if(str == null || str.length() <= 0) return str;

        int lo = 0;
        int hi = str.trim().length() - 1;
        char[] sChar = str.toCharArray();

        while(lo < hi) {
            //Be careful to only decrement/increment pointers until they meet
            while(!isAVowel(sChar[lo]) && (lo < hi)) lo++;
            while(!isAVowel(sChar[hi]) && (hi > lo)) hi--;
            if(isAVowel(sChar[lo]) && isAVowel(sChar[hi])) {
                char temp = sChar[lo];
                sChar[lo++] = sChar[hi];
                sChar[hi--] = temp;
            }
        }

        return String.valueOf(sChar);
    }


    private static boolean isAVowel(char ch) {
        //Ask if y/Y should be included in this set
        return (ch == 'a') || (ch == 'e') || (ch == 'i')
                || (ch == 'o') || (ch == 'u') || (ch == 'A')
                || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U');
    }


    public static void test() {
        String test1 = "soupcan";
        System.out.println(test1 + " : " + solution(test1));

    }

}
