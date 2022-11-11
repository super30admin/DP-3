# Time Complexity: O(m*n)
# Space Complexity: O(1) -> changing the original matrix
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        n = len(matrix)
        
        if n == 0:
            return
        
        for i in range(n-2, -1, -1):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j+1]) + matrix[i][j]
                elif j == n - 1:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j-1]) + matrix[i][j]
                else:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1]) + matrix[i][j]
                    
        res = min(matrix[0])
        
        return res
            