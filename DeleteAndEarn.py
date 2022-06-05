# // Time Complexity :O(N)+max(element)
# // Space Complexity :O(N)+max(element)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxNumber = float("-inf")
        for i in nums:
            maxNumber = max(i, maxNumber)

        dp = [0] * (maxNumber + 1)

        for i in nums:
            dp[i] = dp[i] + i
        # print(dp)

        for i in range(2, maxNumber + 1):
            dp[i] = max(dp[i - 1], dp[i] + dp[i - 2])
        return dp[-1]