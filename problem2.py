# Time Complexity : O(n * m)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes

from ast import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        for i in range(1, rows):
            for j in range(cols):
                min_sum = matrix[i-1][j]
                if j > 0:
                    min_sum = min(min_sum, matrix[i-1][j-1])
                if j < cols - 1:
                    min_sum = min(min_sum, matrix[i-1][j+1])
                matrix[i][j] += min_sum
        
        return min(matrix[-1])
        