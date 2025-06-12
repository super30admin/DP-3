"""
Time Complexity : O(n)
Space Complexity : O(n)
"""

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        max_num = max(nums)
        house = [0] * (max_num + 1)
        
        for num in nums:
            house[num] += num
        
        dp = [0] * (max_num + 1)
        dp[0] = 0
        dp[1] = house[1]
        
        for i in range(2, max_num + 1):
            dp[i] = max(house[i] + dp[i-2], dp[i-1])
        
        return dp[max_num]
