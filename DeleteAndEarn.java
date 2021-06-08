// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem Statement: https://leetcode.com/problems/delete-and-earn/

class Solution {
    
    public int deleteAndEarn(int[] nums) {
        // find the maximum of the nums
        int max = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
        }
        
        int[] points = new int[max + 1];
        
        for (int i=0;i<nums.length;i++) {
            points[nums[i]] += nums[i];
        }
        
        // Create DP matrix with rows as points array and column as 0(not choose) and 1(choose)
        
        int[][] dp = new int[points.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = points[0];
        
        for (int i=1;i<points.length;i++) {
            // not choose
            // return max of previous choose and not_choose
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            
            // choose
            // Sum of previous not_choose and current
            dp[i][1] = dp[i-1][0] + points[i];
        }
        
        return Math.max(dp[dp.length-1][1], dp[dp.length-1][0]);
    }
}

// Recursive Solution

class RecursiveSolution {
    public int deleteAndEarn(int[] nums) {
        // find the maximum of the nums
        int max = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            max = Math.max(max, nums[i]);
        }
        
        int[] points = new int[max + 1];
        
        for (int i=0;i<nums.length;i++) {
            points[nums[i]] += nums[i];
        }
        
        return helper(points, 0, 0);
        
    }
    
    private int helper (int[] points, int index, int max_value) {
        // base case
        if(index >= points.length) {
            return max_value;
        }
        
        // Logic
        int not_choose = helper(points, index + 1, max_value);
        
        int choose = helper(points, index + 2, max_value + points[index]);
        
        return Math.max(not_choose, choose);
    }
}
