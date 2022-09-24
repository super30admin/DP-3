// Time Complexity : O(nums.length) + O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0;i < nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }
        
        int dp[] = new int[max+1];
        for(int i = 0; i < nums.length;i++)
        {
            int idx = nums[i];
            dp[idx] = dp[idx] + idx;
        }
        int skip = 0;
        int take = dp[0];
        for(int i = 1; i < max+1;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }
        
        return Math.max(skip,take);
    }
}