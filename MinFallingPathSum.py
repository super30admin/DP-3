'''
Time Complexity - O(n*n) where n is the dimension of the matrix
Space Complexity = O(1)
'''


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        for i in range(n-2, -1, -1):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j],
                                        matrix[i+1][j+1], matrix[i+1][j-1])
        return min(matrix[0])
