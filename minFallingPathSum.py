class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        
        if not matrix:
            return 0
        
        for i in reversed(range(len(matrix)-1)):
            matrix[i][0] += min(matrix[i+1][0], matrix[i+1][1])
            matrix[i][1] += min(matrix[i+1][0], matrix[i+1][1], matrix[i+1][2])
            matrix[i][2] += min(matrix[i+1][2], matrix[i+1][1])
            
        return(min(matrix[0]))
        