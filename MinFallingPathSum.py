# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Only when a new min appears, we store the previous min in the stack,
# so that when the current min is removed, we can restore the old one in constant time.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0] * n for _ in range(n)]

        for c in range(n):
            dp[n - 1][c] = matrix[n - 1][c]

        for r in range(n - 2, -1, -1):
            for c in range(n):
                if c == 0:
                    dp[r][c] = matrix[r][c] + min(dp[r+1][c], dp[r+1][c+1])
                elif c == n-1:
                    dp[r][c] = matrix[r][c] + min(dp[r+1][c], dp[r+1][c-1])
                else:
                    dp[r][c] = matrix[r][c] + min(dp[r+1][c], dp[r+1][c-1], dp[r+1][c+1])

        return min(dp[0])