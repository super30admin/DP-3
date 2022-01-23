"""
Given an n x n array of integers matrix, 
return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element 
in the next row that is either directly below or diagonally left/right. 
Specifically, the next element from position (row, col) will be 
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


"""

# Time Complexity : O(m*n) m are rows and n are columns
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        if matrix == None or len(matrix) == 0:
            return 0
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix[0])-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1])
                    
        return min(matrix[0])