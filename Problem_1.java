// Time Complexity : O(n) + O(max(nums))
// Space Complexity : O(Max(nums))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//740. Delete and Earn
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        int skip = 0, take = 0;
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] = dp[nums[i]] + nums[i];
        }
        for(int i = 1; i <= max; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}