# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach


class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        dp = [0] * (max(nums) + 1)
        for i in nums:
            dp[i] += i
        for i in range(len(dp)-1, -1, -1):
            if i == len(dp)-3:
                dp[i] = dp[i] + dp[i+2]
            elif i < len(dp)-3:
                dp[i] += max(dp[i+2], dp[i+3])
        return max(dp[0], dp[1])


check = Solution()
print(check.deleteAndEarn([3, 4, 3]))
