"""
Time Complexity : O(n^2)
Space Complexity : O(n^2)
Did this code successfully run on Leetcode : YES
"""
from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0] * n for _ in range(n)]
        
        for j in range(n):
            dp[0][j] = matrix[0][j]
        
        for i in range(1, n):
            for j in range(n):
                candidates = [dp[i-1][j]]
                if j - 1 >= 0:
                    candidates.append(dp[i-1][j-1])
                if j + 1 < n:
                    candidates.append(dp[i-1][j+1])
                
                dp[i][j] = matrix[i][j] + min(candidates)
        
        return min(dp[n-1])
