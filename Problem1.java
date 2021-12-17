//delete and earn
//timecomplexity : o(n)
//spacecomplexity : o(n)
public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        
        int[] dp = new int[max+1];
        for(int i : nums){
            dp[i]=dp[i]+i;
        }
        int skip=0; 
        int take=dp[0];
        for(int i=1;i<max+1;i++){
            int temp = skip;
            skip=Math.max(skip,take);
            take=temp+dp[i];
        }
        
        return Math.max(skip,take);
    }
}
