## Time Complexity : O(n^2)
##Space COmplexity : O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        cols = len(matrix[0])
        rows = len(matrix)

        for i in range (rows - 2,-1,-1):
            for j in range(0,cols):

                if j - 1 < 0:
                    matrix[i][j] = matrix[i][j] +  min(matrix[i+1][j] , matrix[i+ 1][j+1])
                elif j+1 == cols:
                    matrix[i][j] = matrix[i][j] +  min(matrix[i+1][j] , matrix[i+ 1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1] ,matrix[i+1][j],matrix[i+1][j+1] )


        return min(matrix[0])
