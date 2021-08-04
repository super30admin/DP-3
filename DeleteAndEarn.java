/* Time Complexity : O(Max (N , M)), where N is the num array length, M is the max element 
   Space Complexity : O(M) where M is the max element
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No

*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=0;
        for(int i=0;i<nums.length;i++)
            max = Math.max(max,nums[i]); // Find the maximum element
        int[] dp = new int[max+1]; //create an extra array of size max element
        for(int num:nums)
        {
            dp[num]+= num; // store the total earning values
        }
        int skip=0,take=dp[0];
        for(int i=1;i<dp.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,take); //dont consider case
            take = temp + dp[i]; //consider case
        }
        return Math.max(skip,take);
    }
}