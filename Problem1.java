// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
Using Dynamic Programming Approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int x:nums){
            max = Math.max(x,max);
        }
        int[] count = new int[max+1];
        for(int x:nums){
            count[x]++;
        }
        int[][] dp = new int[max+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i <= max; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + count[i]*i;
        }
        return Math.max(dp[max][0], dp[max][1]);
    }
}
