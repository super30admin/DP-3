class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        
        dp = [[0 for j in range(n)] for i in range(m)]
        
        for i in range(n):
            dp[m-1][i]=matrix[m-1][i]
        
        for i in range(m-2,-1,-1):
            for j in range(n):
                if(j-1<0):
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j+1])
                elif(j+1>n-1):
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j-1])
                else:
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],min(matrix[i][j]+dp[i+1][j-1],matrix[i][j]+dp[i+1][j+1]))
        
        #print(dp)
        return min(dp[0])