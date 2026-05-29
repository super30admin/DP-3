class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)

        for row in range(1, n):
            for col in range(n):
                best_prev = matrix[row - 1][col]

                if col > 0:
                    best_prev = min(best_prev, matrix[row - 1][col - 1])

                if col < n - 1:
                    best_prev = min(best_prev, matrix[row - 1][col + 1])

                matrix[row][col] += best_prev

        return min(matrix[n - 1])

        # Time Complexity: O(n^2), where n is the number of rows and columns
        # Space Complexity: O(1), modifying the input matrix in-place