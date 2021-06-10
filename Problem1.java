
//740.
// Time Complexity : O(n) array length
// Space Complexity : O(N) array to store values
// Did this code successfully run on Leetcode : Yes

class Solution {

   
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002];

        for(int i = 0; i < nums.length; i++)
        {
            sum[nums[i]] += nums[i];
        }

        for(int i = 2; i < sum.length; i++)
        {
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10001];
    }
}