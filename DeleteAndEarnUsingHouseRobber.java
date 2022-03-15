/**
 * Time complexity is O(max num)
 * space complexity is O(max num)
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
             max = Math.max(num, max);
        }
        
        int[] houses = new int[max+1];

        for(int num : nums) {
            houses[num] = houses[num] + num;
        }
        return rob(houses);
    }
    
    private int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}