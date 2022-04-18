'''https://leetcode.com/problems/minimum-falling-path-sum/
Given an n x n array of integers matrix, return the minimum sum of any 
falling path through matrix.
A falling path starts at any element in the first row and chooses the element 
in the next row that is either directly below or diagonally left/right. 
Specifically, the next element from position (row, col) 
will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
'''


# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def minFallingPathSum(self, matrix: 'list[list[int]]') -> int:
        if matrix is None or len(matrix) == 0: return 0
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m-2, -1, -1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        
        return min(matrix[0])
                    
                    
        
        