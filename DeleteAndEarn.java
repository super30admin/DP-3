// Time Complexity : O(max(n,m)) n is length of original array m is the value of maximum element
// Space Complexity : O(m) m is the value of maximum element in nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        
        for(int num : nums)         // find maximum in nums
        {
            max = Math.max(max,num);
        }
        
        int dp[] = new int[max+1];
        
        for(int num:nums)  // Preprocess data to calculate value contributed by each unique element of nums
        {
            dp[num]+=num;
        }
        
        // Apply House Robber technique to preprocessed data

        int prevMax = 0;
        int currMax = 0;
        for(int i=0;i<dp.length;i++)
        {
            int temp=currMax;
            currMax = Math.max(currMax, prevMax+dp[i]);
            prevMax = temp;
        }
        
        return currMax;
        
    }
}