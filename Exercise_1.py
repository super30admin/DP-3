# Time Complexity: O(n+k) -> k is the max value in nums
# Space Complexity: O(n+k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m = max(nums)
        
        dp = [0]*(m+1)

        for i in range(len(nums)):
            dp[nums[i]]+=nums[i]
            
        skip = 0
        take = dp[0]
        
        for i in range(1, len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        
        return max(skip, take)