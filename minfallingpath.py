class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m-2,-1,-1):
            for j in range(n-1,-1,-1):
                
                if j==0:
                    matrix[i][j] = min( matrix[i][j]+matrix[i+1][j],matrix[i][j]+ matrix[i+1][j+1])
                elif j==n-1:
                     matrix[i][j] =min( matrix[i][j]+matrix[i+1][j], matrix[i][j]+matrix[i+1][j-1])
                else:
                     matrix[i][j] = min(matrix[i][j]+ matrix[i+1][j] , matrix[i][j]+matrix[i+1][j-1],matrix[i][j]+matrix[i+1][j+1])
        ans = matrix[0][0]
        for i in range(0,n):
            ans = min(ans,matrix[0][i])
        return ans

                