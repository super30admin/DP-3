# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0:
            return 0

        rows = len(matrix)
        cols = len(matrix[0])
        i = 0

        for i in range(1, rows):
            for j in range(cols):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + \
                        min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == cols-1:
                    matrix[i][j] = matrix[i][j] + \
                        min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    two_corners_min = min(matrix[i-1][j + 1], matrix[i-1][j-1])
                    matrix[i][j] = matrix[i][j] + \
                        min(matrix[i-1][j], two_corners_min)

        return min(matrix[i])
