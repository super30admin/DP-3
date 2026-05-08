// Time Complexity : O(n) where n is the total length of nums array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution
{
    public int DeleteAndEarn(int[] nums)
    {
        int max = nums[0];

        for (int i = 1; i < nums.Length; i++)
        {
            max = Math.Max(max, nums[i]);
        }

        int[] dp = new int[max + 1];

        for (int i = 0; i < nums.Length; i++)
        {
            dp[nums[i]] += nums[i];
        }

        for (int i = 0; i < dp.Length; i++)
        {
            int firstPrev = (i - 1) >= 0 ? dp[i - 1] : 0;
            int secondPrev = (i - 2) >= 0 ? dp[i - 2] : 0;

            dp[i] = Math.Max(firstPrev, secondPrev + dp[i]);
        }

        return dp[dp.Length - 1];
    }

}