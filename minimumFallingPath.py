# Update each cell with the minimum falling path sum from the row below
# TC:O(n^2) Iterating over n rows with n columns each
# SC: O(1) Modifying the input matrix in place

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # check if matrix does not exist
        if len(matrix) == 0:
            return 0
        n = len(matrix)  # get the length

        for i in range(n - 2, -1, -1):  # check from the mid row
            for j in range(n):  # iterate through mid row
                if j == 0:  # first index of mid row
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == n - 1:  # last index of mid row
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:  # middle index of mid row
                    matrix[i][j] += min(
                        matrix[i + 1][j - 1], matrix[i + 1][j], matrix[i + 1][j + 1]
                    )
        return min(matrix[0])  # return minimum path from the first row


sol = Solution()
matrix = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]
print(sol.minFallingPathSum(matrix))
