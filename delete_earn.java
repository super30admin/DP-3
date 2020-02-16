// Time Complexity : O(N) number of elements of nums
// Space Complexity : O(N) new do array used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve problem by own


// Your code here along with comments explaining your approach: Same as class

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        //we need to find the max value from the array. 
        //So that we can calculate sum of all elements even if it is not present in the array
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        //create a new array to calculate the sum of all occurances of each element in nums
        int[] dp = new int[max+1]; //initialize the array
        
        //find sum
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] = dp[nums[i]] + nums[i];
            System.out.println(dp[nums[i]]);
        }
        
        int skip = 0;
        int take = 0;
        for(int i=0; i<dp.length; i++){
            int curr_skip = Math.max(skip,take);
            int curr_take = skip + dp[i];
            skip = curr_skip;
            take = curr_take;
        }
        
        
        return Math.max(skip,take);
    }
}
