// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: using radix sort and then using the approach of house robber- dp array and checking max of i-2 and i-3 elements





class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        dp = [0 for i in range(max(nums)+1)]
        
        for num in nums:
            dp[num] += num
        
        for i in range(3, len(dp)):
            dp[i] = max(dp[i] + dp[i-2], dp[i]+dp[i-3])
            
        return max(dp)
