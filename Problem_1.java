/* 

Problem1: (https://leetcode.com/problems/delete-and-earn/)

Time Complexity : O(n) + O(max)
Space Complexity : O(max)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++){
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max+1];

        for(int i=0; i<len; i++){
            int value = nums[i];
            dp[value] = dp[value] + value;
        }

        // DP is the PreProcessed array -- Now apply house-robber
        int take = 0;
        int skip = dp[0];
        for(int i=1; i<max+1; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }

        return Math.max(take,skip);
        
    }
}