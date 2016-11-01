package dp;


public class HouseRobber {

    /*
     * Runtime: O(N)
     */

    public static int solution(int[] homes) {
        if(homes == null || homes.length <= 0 ) return 0;
        if(homes.length == 1) return homes[0];
        if(homes.length == 2) return Math.max(homes[0], homes[1]);
        if(homes.length == 3) return Math.max(homes[0] + homes[2], homes[1]);

        homes[2] += homes[0];
        for(int i = 3; i < homes.length; i++) { //start at the fourth home
            if(homes[i-2] > homes[i-3]) {
                homes[i] += homes[i-2]; //the ith home will be the sum of the ith home and two houses down or three houses down
            } else {
                homes[i] += homes[i-3];
            }
        }

        int len = homes.length;
        return Math.max(homes[len-1], homes[len-2]);
    }

    public static void test(){
        int[] test1 = { 0, 0, 100};
        for(Integer i : test1) System.out.printf("%4d ", i);
        System.out.println();
        System.out.println("Highest profit: " + solution(test1));

        int[] test2 = { 500, 400, 400, 600, 700 };
        for(Integer i : test2) System.out.printf("%4d ", i);
        System.out.println();
        System.out.println("Highest profit: " + solution(test2));

        int[] test3 = { 100, 0, 0, 800 };
        for(Integer i : test3) System.out.printf("%4d ", i);
        System.out.println();
        System.out.println("Highest profit: " + solution(test3));
    }

}
