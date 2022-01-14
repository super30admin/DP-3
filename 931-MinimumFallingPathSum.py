# T.C=>O(m * n)
# S.C=>O(1)
# Approach => Here for every n-2 row we are computig a sum of its index plus the index below it and diagonals to it. In such a way we are iterating it towards top rop. At top row we are comparing all the values with the minVal which is initialized to 10 ** 100.  
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == None: return 0
        if len(matrix) == 1: return matrix[0][0]
        m = len(matrix)
        n = len(matrix)
        for i in range(m - 2, -1, -1):
            for j in range(0, n):
                if(j == 0):
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1]) 
                    
                elif(j == n - 1):
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]))
                
        minVal = 10 ** 100
        for i in range(0, n):
            minVal = min(minVal, matrix[0][i])
            
        return minVal
                    
                    
        