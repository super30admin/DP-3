# TC: O(N*N) - N X N matrix
# SC: O(1)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                matrix[i][j] += min(matrix[i - 1][max(0, j - 1):j + 2])
        return min(matrix[-1])