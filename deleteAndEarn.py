# Using DP (with house robber pattern), taking an Array to store sum of elements and then applying choose not choose on that
# TC: O(max(n)) + O(n) [iterating on dp array that is of size max element] + [iterating through an array to create dp array]
# SC: O(max(n))
from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return

        max_val = max(nums)
        dp = [0] * (max_val + 1)  # create dp array of size max element + 1

        # Populate dp array where dp[i] stores the total sum of value i in nums
        for num in nums:
            dp[num] = dp[num] + num

        skip = 0
        take = dp[0]

        for i in range(1, max_val + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        return max(skip, take)


sol = Solution()
arr1 = [2, 2, 3, 3, 3, 3, 4, 5]
print(sol.deleteAndEarn(arr1))
