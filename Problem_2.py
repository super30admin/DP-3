"""
Problem : 2

Time Complexity : O(n^2)
Space Complexity : O(n^2)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

we have restricted choices to traverse the matrix to get minimum sum, hence starting from the bottom of the matrix,
moving up and calculating the the possible falling sum for each row based on the minimum path sum offered by previous
possible row, moving upside and then calculating the minimum path sum for the 1st row which would be the result

"""

# minimum falling path sum

class Solution(object):
    def minFallingPathSum(self, matrix):
        n=len(matrix)

        dp = [[0 for _ in range(n)] for _ in range(n)]

        # initializing the last row of DP matrix with last row values in the input matrix
        for i in range(n):
            dp[n-1][i]=matrix[n-1][i]

        for i in range(n-2,-1,-1):
            if n>2:
                dp[i][0]=matrix[i][0]+min(dp[i+1][0],dp[i+1][1])
                # calculating minimum path sum between first and last column of each row
                for j in range(1,n-1):
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j-1],min(dp[i+1][j],dp[i+1][j+1]))
                dp[i][n-1]=matrix[i][n-1]+min(dp[i+1][n-2],dp[i+1][n-1])

            else:
                dp[i][0]=matrix[i][0]+min(dp[i+1][0],dp[i+1][1])
                dp[i][1]=matrix[i][1]+min(dp[i+1][0],dp[i+1][1])


        # to calculate minimum path sum in first row of DP matrix and returning it
        minimum=dp[0][0]
        for i in range(n):
            minimum=min(minimum,dp[0][i])
        return minimum