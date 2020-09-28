// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums.length==0 || nums == null)
            return 0;
        
        
        int max = Integer.MIN_VALUE;
        for (int i : nums)
        {
            max = Math.max(max,i);
        }
        
        int[] count = new int[max+1];
        for(int x: nums)
        {
            count[x]++;
        }
        
        int[][] dp = new int[max+1][2];
        dp[0][0]=0;
        dp[0][1]=0;
        
        
        for(int i=1;i<=max;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0] +count[i]*i;
        }
        
        
        return Math.max(dp[max][0],dp[max][1]);
    }
}