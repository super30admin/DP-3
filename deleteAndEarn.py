# Time Complexity: O(max)+O(n)
# Space Complexity: O(n)

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [0 for x in range (max(nums)+1)]
        for i in range (n):
            index = nums[i]
            dp[index] += nums[i]
        
        skip = 0
        take = dp[0]

        for i in range  (1,len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        
        return max(skip, take)
