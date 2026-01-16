// Time Complexity : O(n + maxValue)
// Space Complexity : O(maxValue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        // Edge case
        if (nums.length== 0) return 0;
        int max=0;
        for (int n:nums) {
            max = Math.max(max, n);
        }
        // points[i] = total points we get if we take number i
        int[] points = new int[max + 1];
        for (int n : nums) {
            points[n]=points[n]+n;
        }
        // Same as house robber
        int prev2 = 0;// dp[i-2]
        int prev1 = points[0]; // dp[i-1]
        for (int i=1;i<= max;i++) {
            int curr = Math.max(prev1,prev2+points[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}

