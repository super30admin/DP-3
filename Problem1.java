
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums)
            max = Math.max(num,max);
        int[] arr = new int[max+1];
        for(int num : nums)
            arr[num]+=num;
        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i = 2; i <= max; i++)
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        return dp[max];
    }
}