# Time Complexity : O(M * N) where M = # of rows, N = # of columns
# Space Complexity : O(M * N) where M = # of rows, N = # of columns
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : I was the getting 1 more than the actual answer for the given test case


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
         
        if len(matrix) == 0 or matrix is None:
            return 0
        
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(0, len(matrix[0]), 1):
                if (j - 1) < 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif (j + 1) == (len(matrix[0])):
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], min(matrix[i+1][j-1], matrix[i-1][j+1]))
        
        return matrix[0][0]