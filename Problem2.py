class Solution:
    def minFallingPathSum(self, matrix):
        n = len(matrix)
        # matrix=[[0 for i in range(n)]for j in range(n)]

        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])

                elif j == n - 1:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])

                else:
                    matrix[i][j] += min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][j + 1])

        return min(matrix[n - 1][j] for j in range(n))

#TC:O(n**2)
#SC:O(1)