## passed in leetcode
## TC : O(N^2)
## SC : O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        import math
        if len(matrix)==0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        ans=math.inf
        
        for i in reversed(range(m-1)):
            for j in range(n):
                if (j==0):
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1])
                elif(j==n-1):
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j-1],matrix[i+1][j])
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j-1],matrix[i+1][j],matrix[i+1][j+1])
                
        for i in range(n):
            ans=min(matrix[0][i],ans)
        return ans        
            