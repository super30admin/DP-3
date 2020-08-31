// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
    This problem is similar to House Robber question.
    We use radix sort to sort the given array.
    We find the max points we can earn by not selecting adjacent points.
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max =0;
        for(int i: nums){
            max = Math.max(max,i);
        }
        int[] dp = new int[max+1];
        for(int i=0; i<nums.length;i++){
            dp[nums[i]]+=nums[i];
    }
        int c=0, dc =0;
        for(int i=1; i<=max;i++){
            //dp[nums[i]]+=nums[i];
            int temp =dc;
            dc = Math.max(c, dc);
            
            c= dp[i]+temp;
            
    }
        return Math.max(c,dc);
    }
}