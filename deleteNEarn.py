from typing import List

class Solution:

    def deleteAndEarn(self, nums: List[int]) -> int:
        maxNum = max(nums)
        dp = [0 for _ in range(maxNum+1)]

        for i in range(len(nums)):
            dp[nums[i]] += nums[i]
        
        for i in range(2, len(dp)):
            dp[i] = max(dp[i]+ dp[i-2],dp[i-1])

        return dp[-1]
