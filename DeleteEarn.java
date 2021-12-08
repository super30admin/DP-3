// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// Time Complexity : O(m)
// Space Complexity : O(m)

// This problem we have to give the max we can earn
// Greedy doesnt work for this approach
// we can use dp for this
// after few modifications we can convert the problem to house robber and apply the logic

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int m = Integer.MIN_VALUE;
        for (int i : nums)
            m = Math.max(i, m);
        int[] dp = new int[m + 1];

        for (int i = 0; i < nums.length; i++)
            dp[nums[i]] = dp[nums[i]] + nums[i];
        int skip = 0, take = dp[0];
        for (int i = 1; i < m + 1; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);

    }
}