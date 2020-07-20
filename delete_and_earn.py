# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach:
# We break the problem into subproblems, where each subproblem considers an additional row to be
# added into the subproblem. We iteratively solve each subproblem, and then
# use the previous subproblem to solve the current one. Here each subproblem is whether or not to
# consider a particular value in an array, and then how much can we earn from that.

class Solution:
    def deleteAndEarn(self, nums) -> int:

        if len(nums) == 0: return 0
        # first find the maximum element in the array
        maximum = -9999
        for i in range(len(nums)):
            maximum = max(nums[i], maximum)

        earned = [0 for _ in range(maximum + 1)]

        for i in range(len(nums)):
            earned[nums[i]] += nums[i]

        dp = [[0 for _ in range(2)] for _ in range(maximum + 1)]

        for i in range(1, maximum + 1):
            dp[i][0] = max(dp[i - 1])
            dp[i][1] = earned[i] + dp[i - 1][0]

        return max(dp[maximum])


result = Solution()

print(result.deleteAndEarn([3,4,2]))