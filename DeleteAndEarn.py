# Time Complexity : O(n + max(n))
# Space Complexity : O(max(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Store total points for each number and apple house robber style decision.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = max(nums)

        arr = [0] * (max_val + 1)

        for num in nums:
            arr[num] += num


        dp = [0] * (max_val + 1)

        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])

        for i in range(2, max_val + 1):
            dp[i] = max(dp[i-1], dp[i-2] + arr[i])

        return dp[max_val]


