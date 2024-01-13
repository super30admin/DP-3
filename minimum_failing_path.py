"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of cols of matrix
Space Complexity : O(1) as no auxillary data structure is used
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])
        minSum = float('inf')
        for i in range(1, m):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] = min(
                        matrix[i-1][j], matrix[i-1][j+1]) + matrix[i][j]
                elif j == n-1:
                    matrix[i][j] = min(
                        matrix[i-1][j], matrix[i-1][j-1]) + matrix[i][j]
                else:
                    matrix[i][j] = min(
                        matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1]) + matrix[i][j]

        for j in range(n):
            minSum = min(minSum, matrix[m-1][j])

        return minSum
