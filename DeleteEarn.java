class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max =Integer.MIN_VALUE;
        for(int i:nums)
            max = Math.max(max,i);
        
        int[] uniqueNums = new int[max+1];
        
        for(int i : nums)
            uniqueNums[i] += i;
        
        int[] dp = new int[uniqueNums.length+1];
        dp[0] = 0;
        dp[1] = uniqueNums[1];
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1],uniqueNums[i]+dp[i-2]);
        }
        return dp[max];
    }
}
