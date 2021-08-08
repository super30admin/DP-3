"""
DP approach where we store the last minimus sum in matrix rows
similar to painting house question
TC - O(nm)
SC - O(1)
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix is None or not matrix:
            return -1
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1])
                elif j == (len(matrix[0]) - 1):
                    matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j])
                else:
                    matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        return min(matrix[-1])

