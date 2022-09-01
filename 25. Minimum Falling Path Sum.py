class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0 or matrix is None:
            return -1
        m = len(matrix)
        n = len(matrix[0])
        if m == 1 and n == 1: return matrix[0][0] 
        
        for i in range(m-2, -1, -1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], min(matrix[i+1][j], matrix[i+1][j+1]))
                    
        result = 99999
        for r in range(n):
            result = min(result, matrix[0][r])
        return result