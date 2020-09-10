Time Complexity: O(n)
Space Complexity: O(n). DP array
Ran successfully on Leetcode?: yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int skip = 0, take = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        
        int[] dp = new int[max];
        
        for(int i = 0; i < nums.length; ++i){
            dp[nums[i] - 1] += 1;
        }
        
        for(int i = 1; i <= max; ++i){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + i*dp[i-1];
        }
        
        return Math.max(skip, take);
    }
}
