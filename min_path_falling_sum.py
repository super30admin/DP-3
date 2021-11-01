# // Time Complexity : O(m*n) where m,n are the number of rows,cols of the matrix
# // Space Complexity : O(m*n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0 for i in range(col)] for j in range(row)]
        
        dp[0][:] = matrix[0][:]
        
        for i in range(1,row):
            for j in range(col):
                if j == 0 and j == col-1:
                    dp[i][j] = matrix[i][j] + dp[i-1][j]
                elif j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j],dp[i-1][j+1])
                elif j == col - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j],dp[i-1][j-1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j],min(dp[i-1][j-1],dp[i-1][j+1]))
        return min(dp[-1][:])