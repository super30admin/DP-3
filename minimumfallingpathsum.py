# // Time Complexity : O(n**2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def minFallingPathSum(self, matrix) -> int:
        n = len(matrix)

        for i in range(n-2,-1,-1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])

        minFallingSum = float('inf')
        for i in matrix[0]:
            minFallingSum = min(minFallingSum, i)
        
        return minFallingSum
