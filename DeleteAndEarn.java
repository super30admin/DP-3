class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num,max);
        }
        int[] dp = new int[max+1];
        for(int num : nums){
            dp[num] += num; 
        }
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i]+dp[i-2],dp[i-1]);
        }
        return dp[max];
    }
}