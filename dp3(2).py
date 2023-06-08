"""
Time Complexity : O(N * N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes



Problem_1:  Minimum Falling Path Sum
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        """
        Time Complexity : O(N * N)
        Space Complexity : O(N * N)
        """
        if len(matrix) == 0: return 0
        
        n = len(matrix)
        
        min_val = float('inf')
        
        dp = [[float('inf') for _ in range(n)] for i in range(n)]
        
        for i in range(0, len(dp[0])):
            dp[n-1][i] = matrix[n-1][i]
       
        for i in range(n-2, -1, -1):
            for j in range(0, len(dp[0])):
                if (j == 0):
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
                elif(j == (n-1)):
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], min(dp[i + 1][j - 1], dp[i + 1][j + 1]))
                     
        for i in range(len(dp[0])):
                     min_val = min(min_val, dp[0][i])
                     
                     
        return min_val
