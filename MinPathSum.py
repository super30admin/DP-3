from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0 for _ in range(cols)] for _ in range(rows)]

        def get_min(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols:
                return float('inf')
            return dp[r][c]

        for r in range(rows):
            for c in range(cols):
                if r == 0:
                    dp[r][c] = matrix[r][c]
                else:
                    dp[r][c] = matrix[r][c] + min(get_min(r-1, c-1), get_min(r-1, c), get_min(r-1, c+1))

        return min(dp[-1])
