# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        if len(matrix)==1:
            return min(matrix[0])
        dp = [[0]*(rows) for _ in range(cols)] 
        #Take first row of dp matrix as it is 
        for j in range(cols):
            dp[0][j] = matrix[0][j]
        for i in range(1,rows):
            for j in range(cols):
                if j>0 and j<cols-1:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j-1],dp[i-1][j+1])
                #If it is first column it do not have left diagonal element
                elif j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j+1])
                #If it is last column it do not have right diagonal element
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j-1])
        return min(dp[-1])