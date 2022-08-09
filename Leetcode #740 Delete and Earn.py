# Time Complexity: O(max(n)) + O(n)
# Space Complexity: O(max(n))

from math import inf
import math


class Solution:
    def deleteAndEarn(nums):
        if len(nums) == 0 or nums is None:
            return 0

        max_value = inf
        for num in nums:
            max = math.max(max, nums)

        dp = [[0]*2 for i in range(max + 1)]

        for num in nums:
            dp[num] = dp[num] + num

        skip = 0
        take = dp[0]

        for i in range(1, max + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)
