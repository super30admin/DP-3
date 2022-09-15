class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        arr=matrix
        nrows=len(matrix)
        ncols = len(matrix[0])
        dp = [[None for i in range(ncols)] for j in range(nrows)]
        dp[0] = matrix[0][:]
        for i in range(1, nrows):
            for j in range(ncols):
                if j == 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j]
                elif j == len(matrix[0]) - 1:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j + 1], dp[i - 1][j - 1]) + matrix[i][j]
        return min(dp[-1])