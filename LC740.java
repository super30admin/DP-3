class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max = nums[i];
            }
        }
        
        int arr[] = new int[max+1];
        
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]] += nums[i];
        }
        
        int dp[][] = new int[arr.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            
            dp[i][1] = dp[i-1][0] + arr[i];
        }
        
        return Math.max(dp[arr.length-1][0],dp[arr.length-1][1]);
    }
}