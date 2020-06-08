// Time Complexity : O(max(n,m)) where n is size of input array, m is largest value in array
// Space Complexity :O(m)  m is largest value in array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) //Find max value in array
        {
            max = Math.max(max,nums[i]);
        }
        
        int[] dp = new int[max+1];    //Create new array with max+1 size
        
        for(int i=0;i<nums.length;i++)//Record the appearance of multiple values 
        {
            dp[nums[i]] = dp[nums[i]]+nums[i];
        }
        
        for(int i=2;i<dp.length;i++) //logic to get max sum without picking consecutive numbers
        {
            if(dp[i-1]>dp[i]+dp[i-2])
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i] + dp[i-2];
        }


        return Math.max(dp[max],dp[max-1]);
    }
}