
class Solution {
    int []dp;
    public int deleteAndEarn(int[] nums) {
       int max=Integer.MIN_VALUE;
       
        for(int i=0;i<nums.length;i++)
        {
           max=Math.max(max,nums[i]);
        }
        int[] freq=new int[max+1];
        this.dp=new int[max+10];
        for(int i=0;i<max+1;i++)
        dp[i]=-1;
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]+=nums[i];
        }
        int result=helper(freq,0);
        return result;
        
    }
    private int helper(int[] freq,int index)
    {
       if(index>freq.length-1)
       return 0;
       if(dp[index]!=-1)
       return dp[index];
       int x= helper(freq,index+1);
       if(x!=0)
       dp[index+1]=x;
       int y=freq[index]+ helper(freq,index+2);
       if(y!=0)
       dp[index+2]=y;
       return Math.max(x,y);
    }
}