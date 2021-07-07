#
# Time complexity = O(n+(max(nums)-min(nums))) where n is size of nums
# Space complexity = O(max(nums)-min(nums))
# Works on leetcode
#

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        minn = float("inf")
        maxx = -float("inf")
        for i in nums:
            minn = min(minn, i)
            maxx = max(maxx, i)
        dp = [0 for i in range(maxx-minn+2)]
        for i in nums:
            dp[i-minn+1] += i
        skip = 0
        take = 0
        for i in range(1, len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp+dp[i]
        return max(skip, take)
