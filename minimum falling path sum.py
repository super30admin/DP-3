# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp=[[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]
        m=len(matrix)-1
        n=len(matrix[0]) -1
        # print(dp)
        for j in range(n+1):
            dp[m][j]=matrix[m][j]
        # print(dp)
        for i in range(m-1,-1,-1):
            for j in range(n+1):
                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])
                elif j==n:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1],dp[i+1][j+1])
        return min(dp[0])