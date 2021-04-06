// Time Complexity :O(max(M,N))
// Space Complexity :O(M)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] dp = new int[max + 1];
        // add all same numbers and insert into the array
        for (int num : nums) {
            dp[num] = dp[num] + num;
        }
        int skip = 0;
        int take = dp[0];
        for (int i = 1; i < dp.length; i++) {
            int temp = skip;
            // if skipped take the maximum of previous skip and taken value
            skip = Math.max(skip, take);
            // if taken add the skip value of previous one to the current value
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}