// Time Complexity : O(n) + O(k) where n is length of nums array, k is max number of nums array+1
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int DeleteAndEarn(int[] nums) {
        if(nums.Length == 0 || nums ==  null)
            return 0;
        
        int max = nums[0];
        foreach(var n in nums)
        {
            max = Math.Max(n, max);
        }
        
        int[] dp = new int[max +1];        
        foreach(var n in nums)
        {
            dp[n] += n;
        }
        
        int prev = dp[0];
        int curr = dp[1];
        
        for(int i = 2; i < dp.Length; i++)
        {
            int temp = curr;
            curr = Math.Max(curr, prev + dp[i]);
            prev = temp;
        }
        return curr;
    }
}
