// Time Complexity : O(n+k) -- k is the largest number in nums
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
//used bottom up appoach to solve the problem,
//calculated the max possible earning at every selection

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int[] dp = new int[max + 1];
        for (int num : nums)
            dp[num] += num;
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
        }
        return dp[max];
    }
}