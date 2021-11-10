"""
Time Complexity: O(n^2)
Space Complexity: O(n^2)
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])

        dp_array = [[0 for _ in range(cols)] for _ in range(rows)]
        for j in range(0, cols):
            dp_array[rows - 1][j] = matrix[rows - 1][j]

        for row in range(rows - 2, -1, -1):
            for col in range(cols - 1, -1, -1):
                path1 = path2 = path3 = float('inf')
                if row + 1 < rows and col - 1 >= 0:
                    path1 = dp_array[row + 1][col - 1]
                if row + 1 < rows and col < cols:
                    path2 = dp_array[row + 1][col]
                if row + 1 < rows and col + 1 < cols:
                    path3 = dp_array[row + 1][col + 1]
                dp_array[row][col] = matrix[row][col] + min([path1, path2, path3])

        minimum = float('inf')
        for col in range(cols):
            minimum = min(minimum, dp_array[0][col])
        return minimum
