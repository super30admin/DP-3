# Time complexity : O(n^2) where n is both the rowlength and columnlength
# Space complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Idea: This problem is very much similar to paint house except the constraint is to only choose the cells adjacent to current cell and minimize the path sum
# Used the same approach -
# 1. initialize first row of the dp table with values in the matrix (dp table maintains the minimum sum obtained so far at any given index).
# 2. at every cell, the values can come from any column in the previous row  - make sure to check for the edge case where col==0 or n-1

class Solution:
    def minFallingPathSum(self, matrix):
        n = len(matrix)
        dp = [[0 for _ in range(n)] for _ in range(n)]

        dp[0] = matrix[0]

        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                elif j == n-1:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j])
                else:
                    dp[i][j] = matrix[i][j] + \
                        min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
        return min(dp[-1])


solution = Solution()
print(solution.minFallingPathSum([[2, 1, 3], [6, 5, 4], [7, 8, 9]]))
print(solution.minFallingPathSum([[-19, 57], [-40, -5]]))
