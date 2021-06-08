class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        :time complexity: O(n^2)
        :space complexity: O(1)
        """
        # [2,1,3][6,5,4][7,8,9]
        # [(0,0),(0,1),(0,2)][(1,0),(1,1),(1,2)][(2,0),(2,1),(2,2)]
        # [2,1,3][6+1,5+1,4+1][7+5+1,8+4+1,9+4+1]
        
        
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] = min(matrix[i-1][j]+matrix[i][j], matrix[i-1][j+1]+matrix[i][j])
                elif (j == len(matrix[0])-1):
                    matrix[i][j] = min(matrix[i-1][j]+matrix[i][j], matrix[i-1][j-1]+matrix[i][j])
                else:
                     matrix[i][j] = min(matrix[i-1][j-1]+matrix[i][j], matrix[i-1][j]+matrix[i][j], matrix[i-1][j+1]+matrix[i][j])
               
                    
        return min(matrix[len(matrix) - 1])
        

        
        
        