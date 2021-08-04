
// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*Approach

1) just like house robber, we can have 2 decisions
skip and take
2) for that we create a dp array and store all the indexes from 0 to len(max element in array)
eg: [0,100]
-> 0 ...99
now update the values at present index with the respective occurences, just by adding the current value with previous value
3) now after updating the values use 2 variables (choices -> choose and dont choose)
4) we can have the max of choose and dont choose
and calculate sum acording to dp array



*/


class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        
        // get the max element in array 
        int max =0;
        for(int num:nums)
        {
            max= Math.max(max,num);
        }
        
        
        int dp[]= new int[max+1];
        
        
        // create a integer map array
        for(int num:nums)
        {
            dp[num]+=num;
        }
        
        
        //initialize 2 variables choose from dp array (integer map array)
        int skip=0,take =dp[0]; 
            
        for(int i=1;i<dp.length;i++)
        {
            int temp =skip;
            skip=Math.max(skip,take);
            take = temp+dp[i];
        }
        
        return Math.max(skip,take);
    
    }
    
    
}