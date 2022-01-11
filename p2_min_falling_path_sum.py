"""
// Time Complexity : O(M*N) : N : rows,  M : cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == len(matrix[0]) - 1:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1], matrix[i + 1][j + 1])

        return min(matrix[0])