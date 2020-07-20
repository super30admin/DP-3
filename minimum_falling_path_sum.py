# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach:
# We break the problem into subproblems, where each subproblem considers an additional row to be
# added into the subproblem. We iteratively solve each subproblem, and then
# use the previous subproblem to solve the current one. Here, each subproblem is to identlfy
# the optimal path length if a particular row is added in addition to prev row.

class Solution:
    def minFallingPathSum(self, A) -> int:

        if len(A) == 0: return 0
        # first find the maximum element in the array

        dp = A

        for i in range(1, len(A)):
            for j in range(len(A)):
                if j==0 :
                    dp[i][j] = A[i][j]+min(dp[i - 1][j:j + 2])
                elif j == len(A)-1:
                    dp[i][j] = A[i][j]+min(dp[i - 1][j-1:j+1])
                else:
                    dp[i][j] = A[i][j]+min(dp[i - 1][j-1:j+2])

        return min(dp[len(A)-1])


result = Solution()

print(result.minFallingPathSum([[1,2,3], [4,5,6], [7,8,9]]))