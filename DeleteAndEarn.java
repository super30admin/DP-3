// Time Complexity : Max(nums) + O(n)
// Space Complexity : O(Max(nums))
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length == 0 ){
            return 0;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int dp[] = new int[max+1];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]] = dp[nums[i]] + nums[i];
        }
        
        int skip = 0;
        int take = dp[0];
        for(int i=1;i<=max;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }
        return Math.max(skip,take);
    }
}