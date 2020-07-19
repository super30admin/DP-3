# https://leetcode.com/problems/delete-and-earn

# // Time Complexity : o(max_value)
# // Space Complexity : o(max_value)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : None
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        max_value = max(nums)
        list1 = [0 for i in range(max_value + 1)]
        for i in range(len(nums)):
            list1[nums[i]] += nums[i]

        dp = [[0 for i in range(2)] for j in range(max_value + 1)]

        for i in range(1, max_value + 1):
            for j in range(2):
                # include
                if j == 0:
                    dp[i][0] = list1[i] + dp[i - 1][1]
                # exclude:
                else:
                    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1])
        return max(dp[max_value][0], dp[max_value][1])
