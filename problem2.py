#Time Complexity : O(n^2)
#Space Complexity : O(1)
#Any problem you faced while coding this : -

# The approach is to calculate the minimum falling path sum by iterating through the matrix from the bottom row upwards and updating each cell with the minimum sum of the cell's value and the values of its adjacent cells in the row below. It returns the minimum value found in the top row after all updates.


import sys

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        n = len(matrix)
        for i in reversed(range(len(matrix)-1)):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])

        min_val = sys.maxsize
        for j in range(n):
            min_val = min(min_val, matrix[0][j])

        return min_val
