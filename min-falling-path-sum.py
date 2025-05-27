# We use dynamic programming to find the minimum falling path sum.
# We start from the second last row and move upwards.
# For each cell, we add the minimum of the three possible cells from the row below.
# We then return the minimum value in the first row.

# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        # Start from the second last row and move upwards
        for row in range(n-2, -1, -1):
            for col in range(n):
                # For each cell, add the minimum of the three possible cells from the row below
                min_below = matrix[row+1][col]
                if col > 0:
                    min_below = min(min_below, matrix[row+1][col-1])
                if col < n-1:
                    min_below = min(min_below, matrix[row+1][col+1])
                matrix[row][col] += min_below
        # The answer is the minimum value in the first row
        return min(matrix[0])
        