# Time Complexity: O(n) + O(max(n)) were n is the size of nums and max(n) is maximum value of the
# Space Complexity: O(max(n))

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        size = max(nums)
        dp = [0 for i in range(size+1)]

        for i in nums:
            dp[i] += i

        skip = 0
        take = dp[0]

        for i in range(1, len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        return max(skip, take)