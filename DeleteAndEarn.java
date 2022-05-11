class Solution {

    /**
     * We first need to move data into correct format to reduce reding again and again.
     * Create array of earnings. Size - max element from array. This array is house robber array.
     * create 1D DP array and solve using n-1 -> not choose, n-2-> choose current.
     * time:O(n)
     * Space: O(n)
     */
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] earn = new int[max + 1];
        for (int num : nums) {
            earn[num] += num; // array with earning from 0 to max
        }

        //solve using house robber pattern.

        int[] dp = new int[max + 1];
        dp[0] = earn[0];
        dp[1] = Math.max(dp[0], earn[1]);
        for (int i = 2; i < earn.length; i++) {
            dp[i] = Math.max(dp[i - 1], earn[i] + dp[i - 2]);
        }

        return dp[dp.length - 1];
    }
}
