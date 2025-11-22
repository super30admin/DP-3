// Time Complexity :O(max_val)+O(n)
// Space Complexity :O(max_val)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Build array_p where array_p[i] = total points from all is in nums.
//Use DP with dp[i] = max(dp[i-1], dp[i-2] + array_p[i]) to choose between taking or skipping each number
// Return dp[max_val] as the maximum points you can earn.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max_val = 0;
        for (int num : nums) {
            if (num > max_val) max_val = num;
        }

        int[] array_p = new int[max_val + 1];

        for (int num : nums) {
            array_p[num] += num;
        }

        int[] dp = new int[max_val+1];
        dp[0] = array_p[0];
        dp[1] = array_p[1];
        for (int i =2; i<max_val+1; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+array_p[i]);
        }
        return dp[max_val];

        
    }
}