#Time complexity: O(n^2)
#Space complexity: O(1)
class Solution:
    def minFallingPathSum(self, matrix) -> int:
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j]=min(matrix[i+1][j],matrix[i+1][j+1]) + matrix[i][j]
                elif j == len(matrix[0])-1:
                    matrix[i][j]=min(matrix[i+1][j],matrix[i+1][j-1])+ matrix[i][j]
                else:
                    matrix[i][j]=min(matrix[i+1][j],matrix[i+1][j-1],matrix[i+1][j+1])+ matrix[i][j]
        return(min(matrix[0]))
        