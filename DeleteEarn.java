// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //find max in nums
        int max =Integer.MIN_VALUE;
        for(int i:nums)
            max = Math.max(max,i);
        
        int[] uniqueNums = new int[max+1];
        
        //create new array with unique elements but with (element * no of time element is present in nums) so it can be converted to house robber pattern
        for(int i : nums)
            uniqueNums[i] += i;
        
        //at every point check max of previous or current + i-2 (not cosidering i-1)
        int[] dp = new int[uniqueNums.length+1];
        dp[0] = 0;
        dp[1] = uniqueNums[1];
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1],uniqueNums[i]+dp[i-2]);
        }
        return dp[max];
    }
}
