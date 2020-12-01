public class Solution {
    public int DeleteAndEarn(int[] nums) {
         if(nums == null || nums.Length == 0) 
        {
            return 0;
        }
        int max = Int32.MinValue;
        foreach(int num in nums)
        {
            max = Math.Max(max,num);
        }
        int[] dp = new int[max+1];
        foreach(int i in nums)
        {
            dp[i]+=i;
        }
        int skip=0;int take=0;
        for(int j=0;j<dp.Length;j++)
        {
            int temp = Math.Max(skip,take);
            take = skip +dp[j];
            skip = temp;
        }
        return Math.Max(skip,take);
        
    
        
    }
}
