class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0

        m, n = len(matrix), len(matrix[0])

        for i in range(1, m):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif j == m - 1:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i - 1][j], min(matrix[i - 1][j + 1], matrix[i - 1][j - 1]))

        # return min(matrix[-1])

        minimum = 789465132

        for m in matrix[n - 1]:
            if m < minimum:
                minimum = m

        return minimum
        # return min(matrix[-1])