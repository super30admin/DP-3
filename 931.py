'''
Time-O(nxn)
Space-O(nxn)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        return self.mindp(matrix)

    def mindp(self, matrix):
        n = len(matrix)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            dp[0][i] = matrix[0][i]
        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    dp[i][j] = min(
                        dp[i-1][j] + matrix[i][j],
                        dp[i-1][j+1] + matrix[i][j]
                    )
                    continue
                if j == n - 1:
                    dp[i][j] = min(
                        dp[i-1][j] + matrix[i][j],
                        dp[i-1][j-1] + matrix[i][j]
                    )
                    continue
                dp[i][j] = min(
                    dp[i-1][j-1] + matrix[i][j],
                    dp[i-1][j]   + matrix[i][j],
                    dp[i-1][j+1] + matrix[i][j],
                )

        return min(dp[n-1])

