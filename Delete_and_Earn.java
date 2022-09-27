// TC : O(max_element in nums or nums.length)
// SC : O(max_element in nums)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
                max = Math.max(max, nums[i]);
        
        int[] dp = new int[max+1];
        for(int i = 0; i < nums.length; i++) 
            dp[nums[i]] = dp[nums[i]]+nums[i];
        
        return helper(dp);
    }
    
    private int helper(int[] nums) {
        int not_choose = 0;
        int temp = not_choose;
        int choose = 0;
        
        for(int i = 0; i < nums.length; i++) {
            not_choose = Math.max(choose, not_choose);
            choose = temp+nums[i];
            temp = not_choose;
        }
        return Math.max(choose, not_choose);
    }
}
