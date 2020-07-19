# https://leetcode.com/problems/delete-and-earn

# // Time Complexity : o(len(A)^2)
# // Space Complexity : o(len(A)^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : None
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        _max = 9999

        dp = [[_max for i in range(len(A))] for j in range(len(A))]
        for i in range(len(A)):
            dp[0][i] = A[0][i]

        for i in range(1,len(A)):
            for j in range(len(A)):
                if j == 0:
                    dp[i][j] = A[i][j] + min(dp[i - 1][0], dp[i - 1][1])
                elif j == len(A) - 1:
                    dp[i][j] = A[i][j] + min(dp[i - 1][-1], dp[i - 1][-2])
                else:
                    dp[i][j] = A[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1])
        return min(dp[len(A) - 1])
