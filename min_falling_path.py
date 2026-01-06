"""
time - o(n)
space o(1) as we are using the given array
we take the second row and reference the top, top left and top right values
and add the max of those values to the current index value
the min of the last row gives us the value
"""

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 1:
            return min(matrix[0])
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                top = matrix[i - 1][j]
                top_left = float("inf") if j == 0 else matrix[i - 1][j - 1]
                top_right = (
                    float("inf") if j == len(matrix[0]) - 1 else matrix[i - 1][j + 1]
                )
                matrix[i][j] += min(top, top_left, top_right)
        return min(matrix[-1])
