class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
        }
        int size = max+1;
        int[] arr = new int[size];
        
        for(int i = 0; i < n; i++){
            arr[nums[i]]++;
        }
        
        int[] dp = new int[size+1];
        
        for(int i = 0; i < size+1; i++){
            dp[i] = -1;
        }
        
        return deleteAndEarn(size,arr, dp);
    }
    public int deleteAndEarn(int n, int[] nums, int[] dp){
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(((n-1)*nums[n-1])+deleteAndEarn(n-2, nums,dp), deleteAndEarn(n-1, nums, dp));
    }
}