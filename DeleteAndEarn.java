// Time Complexity : O(n) + O(max) where n is the size of nums and max is the maximum value in nums
// Space Complexity : O(max) where max is the maximum value in nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i : nums)
            max = Math.max(max,i);
        int [] arr = new int[max+1];
        for(int i:nums)
            arr[i]+=i;
        
        int []dp = new int[max+1];
        dp[0]=arr[0];
        dp[1]= arr[1];
        
        for(int i =2;i<dp.length;i++)
            dp[i]= Math.max(dp[i-1], dp[i-2]+arr[i]);
        
        return dp[max];
    }
}