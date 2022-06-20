"""
Approach:

For each row, starting on 2nd last row, modify it such that it takes minimum of current value + value in i+1th row, j-1,j,j+1 th column.
For 1st and last column it will need to be modified and handled slightly differently.

TC : O(m*n)
SC : O(1)
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        if rows == 0:
            return -1
        cols = len(matrix[0])
        
        for i in range(rows-2, -1, -1):
            for j in range(cols):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == cols-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j+1], matrix[i+1][j], matrix[i+1][j-1])
        return min(matrix[0])