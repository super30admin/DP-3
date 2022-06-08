# TC : O(len(nums))
# SC : O(len(nums))
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        freq = [0] * (max(nums)+1)
        for n in nums:
            freq[n] += n

        dp = [0] * len(freq)
        dp[1] = freq[1]
        for i in range(2, len(freq)):
            dp[i] = max(freq[i] + dp[i-2], dp[i-1])

        return dp[len(freq)-1]