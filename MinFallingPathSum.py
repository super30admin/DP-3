# Implementation Thought: Use bottom-up DP, filling from the bottom row to the top; each cell’s cost is its value plus the minimum of valid downward moves.
# Time Complexity: O(n^2), where n = len(matrix)
# Space Complexity: O(n^2), due to the dp table of size (n+1)×n.

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        """
        Returns the minimum sum of a falling path through the matrix.
        A falling path starts at any element in the first row and chooses one element from each row,
        moving straight down or diagonally down-left/right.
        """
        n = len(matrix)

        dp = [[0] * n for _ in range(n + 1)]

        for row in range(n - 1, -1, -1):
            for col in range(n):
                if col == 0:
                    dp[row][col] = min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col]
                elif col == n - 1:
                    dp[row][col] = min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col]
                else:
                    dp[row][col] = (
                        min(
                            dp[row + 1][col - 1],
                            dp[row + 1][col],
                            dp[row + 1][col + 1]
                        )
                        + matrix[row][col]
                    )
        
        return min(dp[0])
