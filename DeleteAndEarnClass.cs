public class Solution
{
    public int DeleteAndEarn(int[] nums)
    {
        int max = 0;

        for (int i = 0; i < nums.Length; i++)
        {
            max = Math.Max(max, nums[i]);
        }
        int[] total = new int[max + 1];
        for (int i = 0; i < nums.Length; i++)
        {
            total[nums[i]] += nums[i];
        }
        int[][] dp = new int[total.Length][];

        dp[0] = new int[2];
        for (int i = 1; i < total.Length; i++)
        {
            dp[i] = new int[2];
            dp[i][0] = Math.Max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + total[i];
        }

        return Math.Max(dp[total.Length - 1][0], dp[total.Length - 1][1]);
    }
}