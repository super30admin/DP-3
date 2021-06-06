class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        #if len(matrix) == 1 and len(matrix[0]) == 1: return matrix[0][0]
        n = len(matrix)
        for i in range(1,n):
            for j in range(n):
                if j == 0: 
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], min(matrix[i-1][j-1],matrix[i-1][j+1]))
                
        return (min(matrix[n-1]))
    
#Time complexity is O(n^2) since the matrix is n*n and we are iterating over both rows and columns
#Space complexity is O(1) since we are just modifying the existing array given to us.