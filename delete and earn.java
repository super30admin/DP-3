/*
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        
        max_num = 0
        for i in nums:
            max_num = max(max_num, i)
        
        dp = [0] * (max_num + 1)
        
        for i in nums:
            dp[i] += i
                                            # Now this problem turned into house robber problem    
        skip, take = 0, dp[0]
        for i in range(1, len(dp)):
            temp = max(skip, take)
            take = skip + dp[i]
            skip = temp
        return max(skip, take)
*/
// Time Complexity : O(max(n, m)) where n is max element in array and m is size of array. Consider a case [1,1,1,1]. In this dp will have length 2 but input array has length 4
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained a array where each index will contain the sum of 
// all that index value occuring in nums array. Then it transformed into house robber problem

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max_value = Integer.MIN_VALUE;
        for (int i:nums)
            max_value = Math.max(max_value, i);
        
        int[] dp = new int[max_value + 1];
        for (int i:nums)
            dp[i] += i;
        
        int skip = 0, take = dp[0];
        for (int i=0; i<dp.length; i++){
            int temp = Math.max(skip, take);
            take = skip + dp[i];
            skip = temp;
        }
        
        return Math.max(skip, take);
    }
}