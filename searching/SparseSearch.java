package searching;

public class SparseSearch {

    /*
     * Runtime: O(N)
     */
    public static int solution(String[] strs, String x) {
        if(strs == null || strs.length <= 0) {
            return -1;
        }

        int lo = 0;
        int hi = strs.length - 1;
        int mid;

        while(lo <= hi) {
            mid = (lo + hi)/2;
            if(strs[mid].equals(x)) return mid;
            if("".equals(strs[mid])) {
                int tempMid = mid;
                while(tempMid > 0 && ("".equals(strs[tempMid]))) {
                    if("".equals(strs[tempMid])) tempMid--;
                }
                if(strs[tempMid].compareTo(x) >= 1) {
                    hi = tempMid - 1;
                    continue;
                }

                tempMid = mid;
                while(tempMid < strs.length - 1 && ("".equals(strs[tempMid]))) {
                    if("".equals(strs[tempMid])) tempMid++;
                }
                if(strs[tempMid].compareTo(x) <= -1) {
                    lo = tempMid + 1;
                    continue;
                }

            }
            if(strs[mid].compareTo(x) <= -1) {
                lo = mid + 1;
            }
            if(strs[mid].compareTo(x) >= 1) {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void test() {
        String[] test1 = { "apple", "banana", "cantaloupe" };
        System.out.println(solution(test1, "orange"));


        String[] test2 = { "pennsylvania", "connecticut", "maryland" };
        System.out.println(solution(test2, "connecticut"));


        String[] test3 = { "", "", "aardvark", "", "baloney", "salami", "", "", "", "zucchini", "" };
        System.out.println(solution(test3, "mushroom"));

        String[] test4 = { "", "", "aardvark", "", "baloney", "salami", "", "", "", "zucchini", "" };
        System.out.println(solution(test4, "zucchini"));

    }
}
