# We use dynamic programming to find the maximum points we can earn by deleting elements.
# We create a count array to count the occurrences of each number.
# We then use dynamic programming to find the maximum points we can earn.

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        high = 0
        n = len(nums)
        for i in range(n):
            high = max(high, nums[i])

        freq = [0] * (high+1)
        for num in nums:
            freq[num] += num

        dp = [0] * len(freq)
        dp[0] = freq[0]
        dp[1] = max(dp[0], freq[1] + 0)
        for i in range(2, len(freq)):
            dp[i] = max(dp[i-1], freq[i] + dp[i-2])
        return dp[len(freq)-1]
        