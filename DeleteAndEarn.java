/**
Time Complexity : O(n)
Space Complexity : O(max(nums.length, max element in nums))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[getMax(nums) + 1];
        
        //Populate the dp array.
        //Each index represents the elements in nums and the value represents the total sum
        for(int x: nums) {
            dp[x] += x;
        }
        
        //Similar to house robber problem
        int C=0, DC=0;
        for(int x: dp) {
            int temp = DC;
            DC = Math.max(C,DC);
            C = temp + x;
        }
        return Math.max(C,DC);
    }
    
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int x: nums) {
            if(x > max) {
                max = x;
            }
        }
        return max;
    }
}
