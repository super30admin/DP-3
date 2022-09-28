//T.C- O(N+k)
//S.C- O(N)

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int max= Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            max= Math.max(max, nums[i]);
        }
        int[] dp= new int[max+1];
        for(int i=0; i< nums.length;i++){
            int idx= nums[i];
            dp[idx]=dp[idx]+nums[i];
        }
        int skip=0;
        int take=dp[0];
        for(int i=1;i<max+1;i++){
            int temp=skip;
            skip=Math.max(skip, take);
            take=temp+dp[i];
        }
        return Math.max(skip,take);
    }
}