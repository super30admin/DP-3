// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] dp = new int[10001];
        
        for(int i : nums) {
        	dp[i] += i;
        }
        
        for(int i = 2; i < dp.length; i++) {

        	dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
        }
        return dp[10000];
    }
}
