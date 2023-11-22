// Time Complexity : DP: O(n + max), RECURSION: O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Calculate the max in O(n) for the size of DP array(every no. is put at it's index). Then there are 2 conditions. 1. If we
 * choose to delete a number, then we can get the current max points as sum of current points + points 2 index back as we need
 * to delete the left and right of current number. If we don't choose to delete a number, then points will be that is 1 index
 * back. Max. of these 2 is the max points for current index. Points at last index is the result
 */

class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int n : nums)
            max = Math.max(max, n);

        int[] dp = new int[max + 1];

        for (int n : nums)
            dp[n] += n;

        for (int i = 2; i <= max; i++)
            dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);

        return dp[max];
    }
}

/*
class Solution {
    public int deleteAndEarn(int[] nums) {
        return helper(dp, 0, 0);
    }

     private int helper(int[] dp, int i, int points) {

         //base
         if(i >= dp.length) return points;
         //logic
         int case0 = helper(dp, i+1, points);
         int case1 = helper(dp, i+2, points+dp[i]);

         return Math.max(case0, case1);
     }
}*/
