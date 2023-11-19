import sys

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp=[[0 for i in range(0,len(matrix[0])) ] for j in range(0,len(matrix))]
        for i in range(0,len(matrix[0])):
            dp[-1][i]=matrix[-1][i]

        for i in range(len(matrix)-2,-1,-1):
            for j in range(0,len(matrix[0])):
                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])
                elif j==len(matrix[0])-1:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1],dp[i+1][j-1])

        min1=sys.maxsize
        for i in range(0,len(matrix[0])):
            min1=(min(min1,dp[0][i]))

        print(dp)

        return min1
        
        