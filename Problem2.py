# Time complexity : O(n*n) --> n is the size of the row matrix
# Space complexity : O(n) --> n is the size of the row matrix as we are using a 1-d matrix
# Leetcode : Solved and submitted

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # finding the rows and columns of the matrix
        n = len(matrix) # rows
        m = len(matrix[0]) # columns

        # if there is no element then we return 0
        if n == 0:
            return 0

        # declaring a 1-d matrix to store the max sum according to the path that we'll take
        dp = [0 for _ in range(n)]

        # as this is a bottom up approach, so copy the values of last row to the last row in our dp matrix and then we can begin
        for i in range(m):
            dp[i] = matrix[n-1][i]

        # traversing from the 2nd last row and moving up the matrix while updating the values
        for i in range(n-2,-1,-1):
            # declaring another 1-d matrix as dp values would be overwritten, so we use this to act as a temp space to store and replace the dp array
            current_vals = [0 for _ in range(n)]
            for j in range(m):
                # if we are at the first column, then we take values from either below or from the right but one row below
                if j == 0:
                    current_vals[j] = matrix[i][j] + min(dp[j],dp[j+1])
                # if we are at the last column, then we take values from either below or from the left but one row below
                elif j == m-1:
                    current_vals[j] = matrix[i][j] + min(dp[j],dp[j-1])
                else:
                    # else we are in any middle column, we can have the value from either the left, middle or right column from the row below
                    current_vals[j] = matrix[i][j] + min(dp[j-1],min(dp[j],dp[j+1]))
            # storing the values of dp into temp variable after end of each iteration of row as it is a 1-d array

            dp = current_vals
        # finding the minimum cost from the complete row and then return it as the result
        cost = dp[0]
        for i in range(1,m):
            cost = min(cost, dp[i])

        return cost
