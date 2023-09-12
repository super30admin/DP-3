# Time Complexity: O(n^2)
# Space Complexity: O(1)


class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """

        for i in range(1,len(matrix)):
            for j in range(len(matrix[i])):
                if j != 0 and j!=len(matrix[i])-1:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1])
                elif j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                else:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1])
        return min(matrix[len(matrix)-1])
