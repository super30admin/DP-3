class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix is None or len(matrix)==0:
            return 0
        for i in range(1,len(matrix)):
            for j in range(0,len(matrix[0])):
                if (j==0):
                    matrix[i][j]=matrix[i][j]+(min(matrix[i-1][j],matrix[i-1][j+1]))
                elif(j==len(matrix[0])-1):
                    matrix[i][j]=matrix[i][j]+(min(matrix[i-1][j-1],matrix[i-1][j]))
                else:
                    matrix[i][j]=matrix[i][j]+(min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1]))
        print(matrix)
        res=matrix[-1][0]
        for i in range(0,len(matrix[0])):
            res=min(res,matrix[-1][i])
        return res