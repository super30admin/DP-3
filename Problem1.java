// Time Complexity : O(k) where k is max value in the nums array
// Space Complexity : O(k) where k is max value in the nums array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int maxVal : nums) {
            if (maxVal > max)
                max = maxVal;
        }
        int[] freqArr = new int[max + 1];
        for (int i = 0; i < n; i += 1) {
            freqArr[nums[i]] += nums[i];
        }
        int[] dp = new int[max + 1];
        dp[0] = freqArr[0];
        dp[1] = Math.max(dp[0], freqArr[1]);

        for (int i = 2; i < max + 1; i += 1) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + freqArr[i]);
        }

        return dp[max];
    }
}