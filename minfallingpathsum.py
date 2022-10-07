##Time Complexity : O(n)
##Space Complexity :O(n)
##Did this code successfully run on Leetcode : Yes

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix or len(matrix) == 0:
            return 0

        n = len(matrix)
        dp = [[0 for i in range(n)] for j in range(len(matrix[0]))]
        dp[n - 1] = matrix[n - 1]

        for i in range(n - 2, -1, -1):
            for j in range(len(dp[0])):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
                elif j == len(dp[0]) - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1])
                else:
                    dp[i][j] = matrix[i][j] + dp[i][j] + min(dp[i + 1][j - 1], dp[i + 1][j], dp[i + 1][j + 1])

        return min(dp[0])
        