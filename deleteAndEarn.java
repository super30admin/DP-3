// Time Complexity : O(Max(max element, N))
// Space Complexity : O(Max element)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//If there is any problem which requires maximization or minimization we use the greedy approach

// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        //We initialize with the Min value to compare with the number in array 
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for(int num: nums){
            dp[num] += num;
        }
        //Now we use the House Robber approach
        int skip = 0, take = 0;
        for(int i=0; i < dp.length; i++){
            int temp = Math.max(skip, take); 
            take = skip + dp[i];
            skip = temp;
        }
        return Math.max(skip, take);
    }
}