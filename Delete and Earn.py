class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxnum = max(nums)
        points = [0] * (maxnum + 1)
        for val in nums:
            points[val] += val

        dp = [0] * (maxnum + 1)
        dp[0] = points[0]
        dp[1] = max(points[0], points[1])

        for i in range(2, len(dp)):
            dp[i] = max(dp[i - 1], points[i] + dp[i - 2])
        return dp[-1]


