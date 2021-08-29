public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) { 
        //null case
        if(nums == null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(max < nums[i])
            {
                max = nums[i];
            }
        }
        
        int[] arr = new int[max + 1];
        
        for(int i = 0; i < nums.length; i++)
        {
            arr[nums[i]] += nums[i];
        }
        
        int[][] dp = new int[arr.length][2];
        
        for(int j = 0; j < 2; j++)
        {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < dp.length; i++)
        {
            //choose the number
            dp[i][0] = arr[i] + dp[i - 1][1];
            
            //don't choose
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);            
        }
        
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
