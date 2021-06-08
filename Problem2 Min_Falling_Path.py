# // Time Complexity : O(m*n) where m and n are number of rows and columns respectively
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0

        for i in range(1, len(matrix)):
            for j in range(0, len(matrix)):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif j == len(matrix) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i - 1][j], matrix[i - 1][j - 1], matrix[i - 1][j + 1])

        min1 = 9999999
        for i in range(len(matrix)):
            min1 = min(min1, matrix[len(matrix) - 1][i])
        return min1