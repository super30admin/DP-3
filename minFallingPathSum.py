# Time Complexity :O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No
class Solution(object):
    def minFallingPathSum(self, matrix):
        n=len(matrix)
        dp=[[0 for j in range(n)] for i in range(n)]
        for k in range(n):
            dp[n-1][k]=matrix[n-1][k]
        
        for i in range(n-2,-1,-1):
            for j in range(n):
                if(j==n-1):
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])
                elif(j==0):
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1],dp[i+1][j-1])
        return(min(dp[0]))