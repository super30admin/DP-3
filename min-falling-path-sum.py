# time O(n*n), space O(n*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n=len(matrix)
        dp = [[0] * n for i in range(n)]
        for i in range(n):
            dp[0][i]=matrix[0][i]
        
        for i in range(1,n):
            for j in range(n):
                # first col - 2 val compare
                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j+1])
                # last col - 2 val compare
                elif j == n-1:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j-1])
                # middle - compare all 3
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])
        
        # return the min of the last row
        res = dp[n-1][0]
        for i in range(n):
            res= min(dp[n-1][i],res)
        return res