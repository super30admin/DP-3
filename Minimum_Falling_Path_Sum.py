class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return

        minsum = 0
        row = len(matrix)
        column = len(matrix[0])
        for i in range(1, row):
            for j in range(column):

                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif j == column - 1:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1], matrix[i - 1][j + 1])

        return min(matrix[-1])