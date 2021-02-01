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

        if len(nums) == 0 or nums == None:
            return 0

        dp = [[0 for _ in range(2)] for _ in range(max(nums) + 1)]

        hashset = [0 for _ in range(max(nums) + 1)]
        # check count of all elements
        for item in nums:
            hashset[item] += item

        for row in range(1, len(dp)):
            dp[row][0] = hashset[row] + dp[row - 1][1]  # choose
            dp[row][1] = max(dp[row - 1])  # choose

        print(dp)

        return max(dp[max(nums)])


result = Solution()

print(result.deleteAndEarn([3,4,2]))