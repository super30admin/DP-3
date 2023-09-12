class Solution:
    def deleteAndEarn(self, nums):
        dp = [0]*(max(nums)+1)
        for  i in range(len(nums)):
            dp[nums[i]] += nums[i]

        skip = 0
        take = dp[0]
        for i in range(len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp+dp[i]

        return max(skip,take)

# TC: O(max)+O(n)
# SC: O(n)