# Time Complexity : O(NM),  
# Space Complexity :O(1), 

# Did this code successfully run on Leetcode : 
# yes 

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:



import math
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None and len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len((matrix[0]))
        for i in range(m-2,-1,-1):  
            for j in range(n):
                if( j==0):
                    matrix[i][j] = matrix[i][j]+ min (matrix[i+1][j], matrix[i+1][j+1])
                elif j ==n-1:
                    matrix[i][j] = matrix[i][j]+ min (matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] = matrix[i][j]+ min (matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
        minv = math.inf
        for i in range(n):
            minv = min( minv, matrix[0][i])
        return minv  