class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        ## TC = O(n*n)
        ## SC = O(1)
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):

                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                    
                elif j == len(matrix[0]) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
                    
        #print(matrix)
        return min(matrix[0])