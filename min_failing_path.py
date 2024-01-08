""" Explanation: We iterate through the matrix, and then check which is the min element between (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1)
    from that element. Then, I just get the last internal matrix and get the min the value from that matrix, which should be our min failing path.
    Time: O(n^2)
    Space: O(1)
"""


class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        for row in range(1,len(matrix)):
            for col in range(len(matrix)):
                # update the current element with the min of its upper element
                matrix[row][col] = matrix[row][col] + \
                min(matrix[row - 1][col],
                matrix[row-1][col-1] if col -1 >= 0 else float('inf'),
                matrix[row-1][col+1] if col + 1 < len(matrix) else float('inf'))

        # now the min item on the last row is the result because it is the smallest path sum
        return min(matrix[-1])