// Time Complexity :O(N) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Difficulty in storing the same values in an array.


// Your code here along with comments explaining your approach: Summing up and storing the same values of nums at the value location in an array
// Then iterating through the array with the condition dp[i]=Math.max(dp[i]+dp[i-2],dp[i-1]).


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;       
        int dp[] = new int[10002];
        for(int i=0;i<nums.length;i++)
            dp[nums[i]]+=nums[i];
        
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i]+dp[i-2],dp[i-1]);
        //System.out.println(dp[i]);
        }
        return dp[dp.length-1];
    }
}