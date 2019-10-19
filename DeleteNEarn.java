/*
Author: Akhilesh Borgaonkar
Problem: LC 740. Delete and Earn (DP-3)
Approach: Using Dynamic Programming approach here to find the pattern of repeating sub-problems. 
Time Complexity: O(n) where n is number of elements in nums[]
Space complexity: O(1) constant
Issue: Doesn't pass all the testcases on LC. I will re-work on this after class.
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length+1][2];
        int r=dp.length, c=dp[0].length;
        
        for(int j=0; j<c; j++)
            dp[0][j]=0;
        
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                if(j==1)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j+1] + nums[i-1];
            }
        }
        
        return Math.max(dp[r-1][0], dp[r-1][1]);
    }
}