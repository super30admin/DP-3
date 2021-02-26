// Time Complexity : O(n) where n is the max value in the nums array
// Space Complexity : O(n) where n is the max value in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length ==0) return 0;
        int[] dp = new int[getMax(nums)+1];
        
        for(int x : nums)
            dp[x] += x;
        
        int ch=0,dc=0;
        for(int d:dp){
            int temp = dc;
            dc = Math.max(dc,ch);
            ch = d+temp;
        }
        return Math.max(ch,dc);
    }
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int n:nums)
            max = Math.max(max,n);
        return max;
    }
        
}
