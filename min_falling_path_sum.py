'''
Time complexity: O(n*m)
Space complexity: O(1)
'''

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        n = len(matrix)
        m = len(matrix[0])
        
        for i in range(1, n):
            for j in range(0, m): # since length of row is not fixed
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1]) # current element considered since 'atmost' one column apart => 0, 1
                elif j == m - 1:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1]) # For last element, m-1 and m-2 
                else:
                    matrix[i][j] += min(matrix[i-1][j], min(matrix[i-1][j-1], matrix[i-1][j+1])) # For non-edge elements, consider elements at j-1, j and j+1 
        return min(matrix[n-1])