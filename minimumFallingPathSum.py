class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        n=len(matrix)
        for i in range(n-2,-1,-1):
            for j in range(n):
                if j==0:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==n-1:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j+1],matrix[i+1][j],matrix[i+1][j-1])
        return min(matrix[0])
    
    
    #time complexity--> O(n2)
    #space complexity ---> O(1)