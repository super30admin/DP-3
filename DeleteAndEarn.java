// Time Complexity : O(max(n))+O(n) 
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : YES

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num>max){
                max = num;   // find max element
            }
        }
        
        int[]dp = new int[max+1]; // dp array - 0-max
        
        for(int num:nums){
            dp[num]=dp[num]+num;   //sum of elements in each index
        }
        
        int skip = 0;
        int take = dp[0];
        
        for(int i =1;i<max+1;i++){
            int temp = skip;
            skip = Math.max(skip,take);  // max of previous skip and take
            take = temp+dp[i];    // add previous skip and current sum
        }
        
        // return max of skip and take
        
        return Math.max(skip,take);
        
    }
}