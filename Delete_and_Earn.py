class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return
        dp = [0] * (max(nums) + 1)
        for i in nums:
            dp[i] = i + dp[i]
        skip, take = 0, dp[0]

        for i in range(len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)