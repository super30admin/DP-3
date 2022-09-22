// Time Complexity : O(2N) = O(N) + O(max+1)
// Space Complexity : O(max + 1) = O(max) since the DP array is
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
    public int deleteAndEarn(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        for (int i=0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max + 1];
        for (int i =0; i < nums.length; i++) {
            int idx = nums[i];
            dp[idx] = dp[idx] + idx;
        }

        int skip = 0;
        int take = dp[0];

        for(int i=1; i<dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}