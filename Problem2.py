#  Time Complexity : O(n^2)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0 : 
            return 0
        
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
#             choose which one matrix to choose according too the current position
                if j == 0:
                    matrix[i][j] += min (matrix[i-1][0],matrix[i-1][1])
                elif j > 0 and j < (len(matrix[0]) - 1):
                    matrix[i][j] += min (matrix[i-1][j],matrix[i-1][j-1], matrix[i-1][j+1])
                else:
                    matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j])
        
        return min(matrix[len(matrix)-1])
