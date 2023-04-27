"""
s30 - similar to paint house problem. Bottom up DP. TC = O(N^2) where N is the size of matrix
SC = O(1) since we are modifying the current matrix
Did this code successfully run on Leetcode : yes
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        for i in range(len(matrix)-2, -1, -1):
            for j in range(0, len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix[0])-1:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1])
        return min(matrix[0])