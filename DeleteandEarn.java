class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int earnedAmount = 0;
        int max = Integer.MIN_VALUE;
        

        //find maximum element in nums
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }

        //initialize the array with max+2
        int[] dp = new int[max+1];
        
        //find total value each num
        for(int num:nums){
            dp[num]+= num;
        }
        
        
       //similar to house robber problem
        int skip = 0, take = 0;
        
        for(int i=0;i<dp.length;i++){
            int temp = Math.max(skip,take);
            take = skip + dp[i];
            skip = temp;
        }
        
        return Math.max(skip, take);
    }
}