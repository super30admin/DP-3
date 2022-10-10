#TC O(n2)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        dp=[[max(matrix)]*n for _ in range(m)]
        for i in reversed(range(m)):
            for j in range(n):
                if i ==(m-1):
                    dp[i][j]= matrix[i][j]
                elif j == 0:
                    dp[i][j]=matrix[i][j]+(min(dp[i+1][j],dp[i+1][j+1]))
                elif j == n-1:
                    dp[i][j]=matrix[i][j]+(min(dp[i+1][j],dp[i+1][j-1])) 
                else:
                    dp[i][j]=matrix[i][j] +(min(dp[i+1][j],dp[i+1][j-1],dp[i+1][j+1]))
        return min(dp[0])  