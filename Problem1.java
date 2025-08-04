public class Problem1 {
    //For this We first calculate total points for each number. Then, we through numbers in order, we decide for each whether to take it or skip it, based on which gives a better total.
    // TC is O(n+m) and SC is O(n)
     public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int[] sum = new int[max + 1];
        for (int num : nums)
            sum[num] += num;
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = sum[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[max];
    }

}
