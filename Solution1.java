// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I created a temporary array arr of size = maximum element of nums + 1. Then, I iterated through the nums array and populated
 * arr with the total sum to which each element in nums adds up to and stored them as arr[nums[i]] + = nums[i]. 
 */
class Solution1 {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }

        int arr[] = new int[max+1];
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]+=nums[i];
        }
        int dp[] = new int[arr.length];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for(int i=2;i<dp.length;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[dp.length-1];

    }
}