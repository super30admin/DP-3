# The I/P array of this problem is converted to match the input for the House robber problem.
# The following is the optimized DP approach for the House robber problem.
#  Time complexity is O(n) and Space complexity is constant

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums: return 0
        max_el = max(nums)
        dp = [0 for _ in range(max_el+1)]
        for num in nums:
            dp[num] += num
        skip, pick = 0, dp[0]
        for i in range(1, len(dp)):
            temp = skip
            skip = max(pick, skip)
            pick = temp + dp[i]
        return max(pick, skip)
