// Time Complexity : O(2*n + max)
// Space Complexity : O(2*max)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int x:nums)
            max = Math.max(max,x);
        int[] a = new int[max+1];
        
        for(int x:nums)
            a[x]++;
        Integer[] dp = new Integer[max+1];
        return solve(a,1,dp);
    }

    private int solve(int[] a,int i,Integer[] dp){
        if(i>=a.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int pick = a[i]*i + solve(a,i+2,dp);
        int notPick = solve(a,i+1,dp);

        return dp[i] = Math.max(pick,notPick);
    }
}