class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++)
            max = Math.max(max, nums[i]);

        int[] arraySum = new int[max+1];
        for(int i =0; i<nums.length; i++)
            arraySum[nums[i]] = arraySum[nums[i]] + nums[i];

        int[][] dp = new int[arraySum.length+1][2];
        for(int i=1; i<arraySum.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + arraySum[i];
        }

        return Math.max(dp[arraySum.length-1][0], dp[arraySum.length-1][1]) ;
    }
}