# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


#  Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        dp = [[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]

        dp[0] = matrix[0]

        for i in range(1, len(matrix)):
            for j in range(0, len(matrix[0])):

                if j == 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j]

                elif j == len(matrix[0]) - 1:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j]

                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j]

        return min(dp[-1])

