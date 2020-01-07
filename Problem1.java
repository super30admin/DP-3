// Time Complexity :
//      m - size of A , n - size of each array 
//      deleteAndEarn() - O(m*n)
//      rob() - O(n)
//      
// Space Complexity :
//      deleteAndEarn() - O(n)
//      rob() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int maxElm = Integer.MIN_VALUE;
        
        for(int i=0; i< nums.length; ++i)
        {
            if(nums[i] > maxElm)
                maxElm = nums[i];
        }
        
        int[] dp = new int[maxElm+1];
        
        for(int i=0; i < nums.length; ++i)
        {
            dp[nums[i]] += nums[i];
        }
        
        
        //do house robber problem on the dp array
        return rob(dp);
    }
    
    private int rob(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        else
        {
            int chosen = 0, notChosen = 0;
            
            for(int i = 1; i <= nums.length; ++i)
            {
                int temp = chosen;
                
                chosen = notChosen + nums[i-1];
                notChosen = Math.max(temp, notChosen);
            }
            
            return Math.max(chosen, notChosen);
        }
    }
}