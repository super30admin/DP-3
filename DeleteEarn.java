class Solution {
    public int deleteAndEarn(int[] nums) {
       int max = 0;
        //edge
        if(nums == null || nums.length == 0 ) return 0;
        
        for(int i =0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        
        int[] dp = new int[max+1];
        int nc =0; int c= 0;
       
         for(int num : nums){
             dp[num] += num;
         }
       
        for(int i =0 ; i< dp.length ;i++){
            int temp = c;
              c = dp[i] + nc;
            nc = Math.max(temp,nc);
        }
        return Math.max(c,nc);
            
    }
}

/*
TimeComplexity:O(n)
SpaceComplexity:O(n)
*/
