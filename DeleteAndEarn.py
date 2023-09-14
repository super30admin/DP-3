# Input: nums = [3,4,2]
# Output: 6
#tc: O(n)
#sc: O(n)

class Solution:
    def deleteAndEarn(nums):
        if not nums:
            return 0
        maxN = max(nums)

        dp = [0]*(maxN+1)

        for i in range(nums):
            index = nums[i]
            dp[index] += nums[i]

        skip, take = 0, dp[0]
        for i in range(maxN+1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)