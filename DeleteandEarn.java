//T.C = O(max(n,maxelement))
//S.C = O(maxele)
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int num : nums)
        {
            max = Math.max(num,max);
        }
        
        int[] dp = new int[max+1];
       
        for(int i=0;i<nums.length;i++)
        {
            dp[nums[i]]= dp[nums[i]] + nums[i];
        }
       
      
        int skip = 0 , take = dp[0];
        for(int i=0;i<dp.length ;i++)
        {
            int temp= skip;
            skip = Math.max(skip,take);
            take= temp + dp[i];
        }
        return Math.max(skip,take);
    }
}