# This problem is similar to the Paint House problem
# T.C is O(m*n) and SC is constant ( We are modifying the I/P array)
# We have repeated subproblems hence we use DP


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix: return 0
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1])
                elif j == len(matrix[0])-1:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1],matrix[i-1][j-1])
        return min(matrix[len(matrix)-1])
