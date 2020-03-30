/**
 * Time Complexity - O(len) Here len = 10001
 * Space Complexity - O(len) - Here - len = 100001
 * This code ran on leetcode
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int[] dp = new int[10001];

        for(int num : nums){
            dp[num]++;
        }


        for(int i=2; i < 10001; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i] * i);
        }
        return dp[10000];
    }
}