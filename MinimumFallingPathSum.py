# Time Complexity : O(rows*cols)
# Space Complexity : O(rows*cols)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We will use DP nxn array to store the minimum path found yet at every matrix cell and then return the minimum of these paths from the last row.

from typing import List
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows=len(matrix)
        cols=len(matrix[0])
        dp=[[0 for j in range(cols)]for i in range(rows)]
        print(dp)
        dp[0]=[i for i in matrix[0]]
        print(dp)
        
        for i in range(1,rows):
            for j in range(0,cols):
                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j+1])
                elif j==cols-1:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j-1],dp[i-1][j])
                else:                            
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])
                    
        return min(dp[rows-1])