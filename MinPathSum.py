# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
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
        dirs = [[-1, -1], [-1, 0], [-1, 1]]

        psum = [[float('inf') for row in range(rows)] for col in range(cols)]

        for i in range(cols):
            psum[0][i] = matrix[0][i]

        for row in range(1, rows):
            for col in range(cols):
                for d in dirs:
                    r, c = d
                    r = row + r
                    c = col + c
                    if (r >= 0 and r < rows) and (c >= 0 and c < cols):
                        psum[row][col] = min(
                            psum[row][col], psum[r][c] + matrix[row][col])

        return min(psum[row])
