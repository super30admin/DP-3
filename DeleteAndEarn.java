// Time Complexity : O(Max(m, n)) , 'm' is maximum value of integer in nums, 'n' is length of nums[]
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int num: nums) {
            max = Math.max(max, num);
        }
        
        int[] dp = new int[max + 1];
        
        for (int num: nums) {
            dp[num] = dp[num] + num;
        }
        
        int skip = 0, take = 0;
        
        for(int i = 0; i < dp.length; i++) {
            int temp = Math.max(skip, take);
            take = skip + dp[i];
            skip = temp;
        }
        
        return Math.max(skip, take);
    }
}