# Time Complexity : O(length *  height)
# Space Complexity: O(length *  height)
#  Did this code successfully run on Leetcode : Ye

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0

        length = len(matrix[0])
        height = len(matrix)

        for i in range(height - 2, -1, -1):
            for j in range(0, length):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == length - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]))

        minValue = float('inf')

        for num in matrix[0]:
            minValue = min(minValue, num)

        return minValue
