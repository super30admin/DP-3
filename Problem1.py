"""
DP approach
similar to house robbery question
TC - O(n) + O(max_element)
SC - O(n) + O(max_element)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or not nums:
            return -1
        maxx = sorted(nums)[-1]
        dp = [0 for i in range(maxx + 1)]
        for i in nums:
            dp[i] += i
        skip, take, temp = 0,0,0
        for i in range(len(dp)):
            temp = skip
            skip = max(skip,take)
            take = temp + dp[i]
        return max(skip,take)