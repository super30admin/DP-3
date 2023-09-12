# Time Complexity: O(n) were n is the number of rows in the matrix.
# Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        result = 0
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j] = matrix[i][j]+  min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix[0]) -1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] = matrix[i][j] +  min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])

