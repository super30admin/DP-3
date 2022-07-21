# Time Complexity = O(m * n)
# Space Complexity = O(1)
# Similar to Paint House Problem - LC 256


class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        
        m = len(matrix)         # Number of rows 
        n = len(matrix[0])      # Number of cols
        
        for i in range(n-2, -1, -1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                    
                    
                elif j == n - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j - 1], matrix[i + 1][j])
                    
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j + 1], min(matrix[i + 1][j], matrix[i + 1][j - 1]))
                    
        
        minV = sys.maxsize
        for j in range(n):
            minV = min(minV, matrix[0][j])
            
        return minV
            