// Time Complexity : O(N) + O(Max) = O(N)
// Space Complexity : O(Max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        // find max number in given array to create a dp array
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // create a dp array of size max + 1 so that we can accomodate max number also
        // now we will keep adding value in nums at dp position value index 
        int[] dp = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            dp[index] += index;
        }

        // it's a dp solution same as House Robber problem 
        // check House Robber problem for below explanation
        int skip = 0;
        int take = 0;

        for(int i = 1; i < dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}