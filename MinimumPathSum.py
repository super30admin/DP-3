#Time Complexity: O(n^2)
#Space Complexity: O(n^2)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m=len(matrix)
        n=len(matrix[0])
        dp=[[0]*(n+1) for _ in range(m+1)]
        for i in range(m-1,-1,-1):
            for j in range(0,n):
                #case:
                if j==0:
                    dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+matrix[i][j]
                elif j==n-1:
                    dp[i][j]=min(dp[i+1][j],dp[i+1][j-1])+matrix[i][j]
                else:
                    dp[i][j]=min(dp[i+1][j],dp[i+1][j+1],dp[i+1][j-1])+matrix[i][j]
        print(dp)

        return min(dp[0][:-1])