# Time Complexity : o(M*M)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Similar to coloring house problem

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1,len(matrix)):
            for j in range(len(matrix)):
                if j==0:
                    matrix[i][j] =  matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == (len(matrix)-1):
                    matrix[i][j] =  matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] =  matrix[i][j] + min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        return min(matrix[len(matrix)-1])