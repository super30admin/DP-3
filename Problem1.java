// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Problem1 {
    public static int deleteAndEarn(int[] nums) {
        int max = max(nums);
        int[] houses = new int[max + 1];
        int[] dp = new int[max + 1];

        for (int num : nums) {
            houses[num] += num;
        } // rest all will be 0's

        for (int i = 0; i <= max; i++) {
            int rob = 0;
            int notRob = 0;

            // rob
            if (i - 2 > 0) {
                rob = houses[i] + dp[i - 2];
            } else {
                rob = houses[i];
            }

            // notRob
            if (i - 1 > 0) {
                notRob = dp[i - 1];
            } else {
                notRob = 0;
            }

            dp[i] = Math.max(rob, notRob);
        }
        return dp[max];
    }

    public static int max(int[] nums) {
        int maxi = 0;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 2 };
        System.out.println(deleteAndEarn(nums));
    }
}