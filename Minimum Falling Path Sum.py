class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix==None or len(matrix)==0:return 0
        n=len(matrix)
        for i in range(n-2,-1,-1):
            for j in range(n):
                if j==0:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==n-1:
                    matrix[i][j]+=min(matrix[i+1][j-1],matrix[i+1][j])
                else:
                    matrix[i][j]+=min(matrix[i+1][j-1],matrix[i+1][j+1],matrix[i+1][j])
        min1=99999999
        for i in range(n):
            min1=min(min1,matrix[0][i])
        return min1