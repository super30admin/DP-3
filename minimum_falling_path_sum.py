#time complexity: O(mxn)
#space complexity: O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if(matrix==None or len(matrix)==0): return 0
        rows=len(matrix)
        columns=len(matrix[0])
        
        for i in range(rows-2,-1,-1):
            for j in range(columns):
                if j==0:
                    matrix[i][j]=matrix[i][j]+ min(matrix[i+1][j], matrix[i+1][j+1])
                elif j==columns-1:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j], matrix[i+1][j-1])
                
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
                    
        return min(matrix[0])