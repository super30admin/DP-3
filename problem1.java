public class problem1 {
    public int deleteAndEarn(int[] nums) {
        //TC - 
        //SC - O(max value in array)
// Time Complexity : O(n) + O(max value in array)
// Space Complexity : O(max value in array) n-> number of elements in given array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
        int max= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        
        int[] dp = new int[max+1];
        
        for(int i=0;i<nums.length;i++){
            int idx = nums[i];
            dp[idx] = dp[idx]+nums[i];
        }
        
        int skip=0;
        int take=dp[0];
        
        for(int i=1;i<max+1;i++){
            int temp = skip;
            
            skip = Math.max(skip,take);
            take = temp +dp[i];
        }
        return Math.max(skip,take);
    }
}
