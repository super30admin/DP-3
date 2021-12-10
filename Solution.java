// Time Complexity :O(n) n = max element in the nums array
// Space Complexity :O(n) n = max element in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Solution {
    public int deleteAndEarn(int[] nums) {
    if(nums==null||nums.length==0)
            return -1;
        int max=Integer.MIN_VALUE;
        // creating ann array to capture array with all earnings together
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int [] dp= new int[max+1];
        // addig the earnings at the corresponding index
        for(int i=0;i<nums.length;i++)
        {
            dp[nums[i]]+=nums[i];
            
        }
        int skip=0;
        int take=dp[0];
        for(int i=1;i<=max;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=dp[i]+temp;
        }
        
        return Math.max(skip,take);
    }
}
