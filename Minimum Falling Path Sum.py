
#Not Mutating the Matrix-
""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        n = len(matrix)
        dp = [[0 for i in range(n)] for j in range(len(matrix[0]))]
        dp[n - 1] = matrix[n - 1]

        for i in range(n - 2, -1, -1):
            for j in range(len(dp[0])):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
                elif j == len(dp[0]) - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1])
                else:
                    dp[i][j] = matrix[i][j] + dp[i][j] + min(dp[i + 1][j - 1], dp[i + 1][j], dp[i + 1][j + 1])

        return min(dp[0])


#Mutating the Matrix-
""""// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def minFallingPathSum(self, matrix):
#         if not matrix or len(matrix) == 0:
#             return 0
#
#         n = len(matrix)
#         for i in range(n - 2, -1, -1):
#             for j in range(len(matrix[0])):
#                 if j == 0:
#                     matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
#                 elif j == len(matrix[0]) - 1:
#                     matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1])
#                 else:
#                     matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j - 1], matrix[i + 1][j], matrix[i + 1][j + 1])
#
#         return min(matrix[0])
