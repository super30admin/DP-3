# // Time Complexity : O(M*N)
# // Space Complexity :O(M*N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])

        dp = [[float("inf")] * m for i in range(n)]
        for j in range(m):
            dp[0][j] = matrix[0][j]
        
        for i in range(1, n):
            for j in range(m):
                dp[i][j] = matrix[i][j] + min(
                    dp[i - 1][k]
                    for k in [j - 1, j, j + 1]
                    if 0 <= k < m
                )

        return min(dp[n - 1])