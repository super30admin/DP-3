# Time Complexity :O(mn)
# Space Complexity :O(mn)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#Use a DP array dp[i][j] to store the minimum falling path sum ending at cell (i, j).
# For each cell, update dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1]) with proper boundary checks.
# Return the minimum value in the last row of dp as the result.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        dp = [row[:] for row in matrix]
        for i in range(n):
            for j in range(m):
                if 0<=j-1 and j+1<m and 0<=i -1:                  
                    dp[i][j] = min(matrix[i][j]+dp[i-1][j],matrix[i][j]+dp[i-1][j+1],matrix[i][j]+dp[i-1][j-1])
                elif 0<=j-1 and 0<=i -1:
                    dp[i][j] = min(matrix[i][j]+dp[i-1][j],matrix[i][j]+dp[i-1][j-1])
                elif j+1<m and 0<=i -1:
                    dp[i][j] = min(matrix[i][j]+dp[i-1][j],matrix[i][j]+dp[i-1][j+1])
                else:
                    dp[i][j] = matrix[i][j]
        return min(dp[n-1])