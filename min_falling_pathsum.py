#TC => o(n^2)
#SC => o(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        for i in range(1,n):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j])
                else :
                    matrix[i][j] += min(matrix[i-1][j-1], min(matrix[i-1][j], matrix[i-1][j+1]))        
        return min(matrix[n-1])  