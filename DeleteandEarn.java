#T(N)= O(N)
# S(N) = O(N)

# Where N is lnegth of nums

class Solution {
    public int deleteAndEarn(int[] nums) {
        int ma=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(ma<nums[i]){
                ma=nums[i];
                
            }
        }
        int[] res= new int[ma+1];
        //System.out.println(res.length);
        for(int i=0;i<nums.length;i++)
        {
            //System.out.println(nums[i]);
            res[nums[i]]= res[nums[i]]+nums[i];
        }
        
        int dp[] =new int[ma+1];
        for(int i=1;i<=ma;i++)
        {
            if(i<2){
                dp[i]=res[i];
            }
            else{
                dp[i]=Math.max(dp[i-1],res[i]+dp[i-2]);
            }
            
        }
        return dp[ma];
        
        
        
    }
}