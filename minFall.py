# Time Complexity : O(n * m)
# Space Complexity : O(n * m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion + memoization.
# From each cell, try all 3 possible downward moves:
# down-left, down, and down-right.
# memo[i][j] stores the minimum falling path sum starting from cell (i, j),
# Start from every column in the first row and take the minimum answer.


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        r = len(matrix) - 1
        c = len(matrix[0]) - 1
        min_path = float('inf')

        def checkpath(i,j,memo):
            if i > r or j > c or i < 0 or j < 0:
                return float('inf')
            if i == r:
               return matrix[i][j]
            if memo[i][j] != None:
                return memo[i][j]
            left = matrix[i][j] + checkpath(i + 1,j - 1,memo)
            down = matrix[i][j]  + checkpath(i + 1,j,memo)
            right = matrix[i][j] + checkpath(i + 1,j + 1,memo)
            memo[i][j] = min(left,down,right)
            return memo[i][j]

        memo = [[None for i in range(c + 1)] for j in range(r + 1)]
        for j in range(c + 1):
            min_path = min(min_path,checkpath(0,j,memo))
        return min_path