# Time Complexity: O(n * n)
# Space complexity: O(1)

# The code successfully ran on Leetcode

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0 or matrix == None:
            return 0
        
        for i in range(1, len(matrix)):
            for j in range(len(matrix[i])):
                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                    
                elif j == (len(matrix[i]) - 1):
                    matrix[i][j] += min(matrix[i - 1][j - 1], matrix[i - 1][j])
                    
                else:
                    matrix[i][j] += min(matrix[i -1][j - 1], min(matrix[i -1][j], matrix[i -1][j + 1]))
                    
        return min(matrix[-1])