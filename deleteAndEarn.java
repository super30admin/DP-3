Time Compelxity-O(n)
Space Complexity-O(1)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp=new int[100001];
        for(int num:nums)
            dp[num]+=num;
        int take=0,skip=0;
        for(int i=1;i<dp.length;i++)
        {
            int tempTake=skip+dp[i];
            int tempSkip=Math.max(skip,take);
            take=tempTake;skip=tempSkip;
        }
        
        return Math.max(take,skip);
    }
}
