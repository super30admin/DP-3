
# Exhaustive Approach
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        N = len(matrix)

        def solve(row, col):
            if row == N:
                return 0

            down = float("inf")
            right = float("inf")
            left = float("inf")

            if col <= N - 1 and col >= 0:
                down = matrix[row][col] + solve(row + 1, col)
            if col > 0:
                left = matrix[row][col - 1] + solve(row + 1, col - 1)
            if col < N - 1:
                right = matrix[row][col + 1] + solve(row + 1, col + 1)

            return min(down, left, right)

        return solve(0, 0)


# Bottom Up Approach
