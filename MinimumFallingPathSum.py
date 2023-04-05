#Time complexity is O(m*n) as we are traversing through the whole matrix.
#Space complexity=O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix==None or len(matrix)==0:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        minimum=sys.maxsize
        for i in range(m-2,-1,-1):#T>C=O(m*n)
            for j in range(n):
                if j==0:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==n-1:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1],matrix[i+1][j-1])
        for i in range(n):
            minimum=min(minimum,matrix[0][i])
        return minimum