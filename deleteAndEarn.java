class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            max=Math.max(max,nums[i]);
        
        int[] dp=new int[max+1];
        
        for(int i=0;i<n;i++)
        {
            int val=nums[i];
            dp[val]+=val;
        }
        
        int skip=0;
        int take=dp[0];
        
        for(int i=1;i<max+1;i++)
        {
            int temp=skip;
            skip=Math.max(skip,take);
            take=dp[i]+temp;
        }
     
        return Math.max(skip,take);
    }
}

// Time Complexity : O(n) + O(max value)
// Space Complexity : O(max value)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no