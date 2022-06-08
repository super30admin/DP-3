"""
TC: O(m * n)
SC: O(1)
"""

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        for row in range(len(matrix)-2,-1,-1):
            for col in range(len(matrix[0])):
                toAdd =  matrix[row + 1][col]
                if col > 0:
                    toAdd = min(toAdd,matrix[row + 1][col - 1])
                if col < len(matrix[0])-1 :
                    toAdd = min(toAdd, matrix[row + 1][col +1])
                matrix[row][col] = matrix[row][col] + toAdd
        
        return min(matrix[0])
                            