# DP (Bottom Up)
# Submitted successfully
# TC = O(n*n) where n = len(matrix)
# SC = O(1) as we are editing matrix in-place
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix)==0 or matrix==None:
            return 0

        # Starting from 2nd last row and keeping last row as it is
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix)):
                if j==0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j==len(matrix)-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(min(matrix[i+1][j], matrix[i+1][j+1]), matrix[i+1][j-1])

        return min(matrix[0])