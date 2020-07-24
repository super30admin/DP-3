// Time Complexity : O(n) , where n is max in nums
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : still didnt quite get who it was solved.


// Your code here along with comments explaining your approach

import java.util.Collections;

class Solution {
    public int deleteAndEarn(int[] nums) {
        //base case
        if(nums==null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        
        // finding max in nums
        for(int num: nums){
            max = num>max ? num : max;
        }
        
        int[] costs = new int[max+1];
        
        for(int num: nums)
            costs[num] += num;
        
        int[][] dp = new int[max+1][2];
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i=1; i<dp.length; i++){
            //if not choosing then get max of previous row
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
            //if choosing then get its value and not choosing previous row
            dp[i][1] = costs[i] + dp[i-1][0];
        }
        
        return Math.max(dp[max][0], dp[max][1]);
    }
}