# SC: O(n)
# TC: O(n)

import sys

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_element = max(nums)
        dp = [0]* (max_element+1)
        
        for elem in nums:
            dp[elem] += elem
        skip = float('-inf')
        temp = 0
        take = 0
        
        for elem in dp:
            temp = skip
            skip = max(temp, take)
            take = temp + elem
            
        return max(skip, take)
                
