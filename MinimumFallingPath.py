# TC = O(mn)
# SC = O(mn)
# where n is number of rows and m is number of columns in input matrix
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix[0])
        n = len(matrix)
        dp = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(m):
            dp[n - 1][i] = matrix[n - 1][i]

        for i in range(n - 2, -1, -1):
            for j in range(m):
                if j == 0:
                    dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + matrix[i][j]
                elif j == m - 1:
                    dp[i][j] = min(dp[i + 1][j], dp[i + 1][j - 1]) + matrix[i][j]
                else:
                    dp[i][j] = (
                        min(dp[i + 1][j], dp[i + 1][j + 1], dp[i + 1][j - 1])
                        + matrix[i][j]
                    )

        return min(dp[0][:])
