""""// Time Complexity : O(n)+O(max(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def deleteAndEarn(self, nums):
        maximum = max(nums)
        dp = [0] * (maximum + 1)
        for i in nums:
            dp[i] += i
        prev = dp[0]
        curr = max(dp[0], dp[1])
        for i in range(2, len(dp), 1):
            temp = max(curr, prev + dp[i])
            prev = curr
            curr = temp
        return curr
Obj=Solution()
print(Obj.deleteAndEarn([2,2,3,3,3,4]))