# TC: O(N x M) where N is the number of rows of input matrix and M is the no. of columns. Since for every element we iterate on the entire previous row to calculate the minimum. 
# SC: O(1) since we alter the original matrix and do not use any extra space.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0 
        
        rows = len(matrix)
        cols = len(matrix[0])
        
        for i in range(1,rows): 
            for j in range(cols):
#                 if its the first column
                if j == 0 and cols > 1: 
                    matrix[i][j] = min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i-1][j + 1])
#                 if its the last column
                elif j == cols - 1: 
                    matrix[i][j] = min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i-1][j - 1])
                else: 
                    matrix[i][j] = min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i-1][j + 1], matrix[i][j] + matrix[i -1][j - 1])
        
        return min(matrix[cols - 1])
