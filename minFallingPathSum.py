# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def minFallingPathSum(self, A):
        # edge case
        if not A or len(A) == 0:
            return -1
        dp = [[0] * len(A) for i in range(len(A))]

        for i in range(len(A)):
            dp[0][i] = A[0][i]

        for i in range(1, len(A)):
            for j in range(len(A)):
                if j == 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j]
                elif j == len(A) - 1:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j]

        return min(dp[-1])


r = Solution()
A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print("Minimum sum of falling path is", r.minFallingPathSum(A))
